/*
 * TK1 - Exercise
 * (c)2011 Telecooperation Dept. - Darmstadt University of Technology
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License version 2 as
 *  published by the Free Software Foundation;
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND.
 *  ALL LIABILITY, INCLUDING LIABILITY FOR INFRINGEMENT OF ANY PATENTS,
 *  COPYRIGHTS, TRADEMARKS OR OTHER RIGHTS, RELATING TO USE OF THIS
 *  SOFTWARE IS DISCLAIMED.
 *
 *  Authors
 *  Erwin Aitenbichler
 *  Dirk Schnelle
 *  Sebastian Döweling
 */

package com.tu.tk1;

import java.awt.Image;
import java.awt.image.IndexColorModel;
import java.awt.image.MemoryImageSource;

import com.ibm.tspaces.*;

import java.io.Serializable;
/**
 * Calculator for a mandelbrot image.
 * 
 * @author Erwin Aitenbichler
 * @author Dirk Schnelle
 * @author Sebastian Döweling
 */
class MandelCalculator implements Runnable {
    /** Image data. */
    private int data[];
    
    /** Image producer to create an image from the data. */
    private MemoryImageSource mis;

    /** The canvas to display the image. */
    private MandelCanvas canvas;
    TupleSpace tSpace;
    Work w ;
    Tuple resultTuple;
    /**** TUPPLE SPACE DATA***/
 
    
    /**********************************/

    /**
     * Constructs a new object.
     * @param c The canvas to show the image.
     * @param x1 double
     * @param y1 double
     * @param x2 double
     * @param y2 double
     * @param mi int
     */
    public MandelCalculator(MandelCanvas c, double xstart, double ystart, double xend,
                           double yend, int maxiter) {
       
    	 try {
			tSpace = new TupleSpace("mBrot");
			 tSpace.deleteAll();
		} catch (TupleSpaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
        
        canvas = c;
        w = new Work(xstart,  xend,  ystart,  yend,canvas.getWidth(),  canvas.getHeight(),  maxiter);
        data = new int[w.getWidth() * w.getHeight()];
        mis = new MemoryImageSource(w.getWidth(), w.getHeight(), generateColorModel(),data, 0, w.getWidth());
    }


    /**
     * Working method.
     */
    
    
    @SuppressWarnings("static-access")
	public void run() {
        
        try {
           
            
            Tuple dataTuple;
            FieldPS serializedObj = new FieldPS(w); // changed
           
           // System.out.println(tSpace.countN(dataTuple)+" Mandel Data Tuples"); 
            tSpace.write("work",serializedObj); 
           
        	for (int y = 0; y < w.getHeight(); y++) {
            	
             	dataTuple = new Tuple ();
            	dataTuple.add("row");
                dataTuple.add(y);

            	tSpace.write(dataTuple);
            	
            }
        
            
           
          Tuple result = new Tuple("result",new Field (Integer.class),new Field (Serializable.class));
            
 
           tSpace.eventRegister(TupleSpace.WRITE, result, new Callback() {
        	  
        	  
			@Override
			public boolean call(String arg0, String arg1, int arg2,SuperTuple arg3, boolean arg4) {
				
		
				 resultTuple=(Tuple) arg3;
				 int rowData[];
				
							try {
								
								int row = (Integer) resultTuple.getField(1).getValue();
								rowData = (int[]) resultTuple.getField(2).getValue();
								
								for (int j = 0; j < rowData.length; j++) {

									data[((row * w.getWidth()) + j)] = rowData[j];
								}
								Image image = canvas.getToolkit().createImage(mis);
								canvas.setImage(image);
								tSpace.take(arg3);
								
								return false;
							} catch (TupleSpaceException e) {
								
								e.printStackTrace();
							}
							return false;
			}
        	   
           },true);
        
            
          
        
        } catch (Exception e) { 
                System.out.println(e); 
            }
      
    
    } 
    

    /**
     * Gets a color model for the image source.
     * @return IndexColorModel for the image source.
     */
    private IndexColorModel generateColorModel() {
        byte[] r = new byte[255];
        byte[] g = new byte[255];
        byte[] b = new byte[255];

        for (int iter = 0; iter < 255; iter++) {
            r[iter] = (byte) ((iter * 26) % 250);
            g[iter] = (byte) ((iter * 2) % 250);
            b[iter] = (byte) ((iter * 35) % 250);
        }

        return new IndexColorModel(8, 255, r, g, b);
    }
    

    
    
    
}
