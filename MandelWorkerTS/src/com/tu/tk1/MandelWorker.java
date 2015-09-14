package com.tu.tk1;


import java.awt.Color;
import java.util.Random;

import com.ibm.tspaces.Field;
import com.ibm.tspaces.FieldPS;
import com.ibm.tspaces.Tuple;
import com.ibm.tspaces.TupleSpace;


public class MandelWorker implements Runnable{
	private int data[];
	Work w ;
	private boolean gotWork ;
	
	private void getWork(){
		try {
			Tuple baseDataTuple;
    		TupleSpace space1 = new TupleSpace("mBrot");
    		w = new Work();
    		Tuple initWork = new Tuple("work",new FieldPS(Work.class));
    	 	baseDataTuple = space1.waitToRead(initWork);
    		w = (Work) baseDataTuple.getField(1).getValue();
    		data = new int[w.getWidth()];    		    		
    		
    		this.gotWork = true;
		} catch (Exception e) { 
    		System.out.println("exception in worker const  .....");
    		e.printStackTrace();
        }
		
	}
    public MandelWorker(){
	
    	this.gotWork = false;
   
        
    }
    
    /*******************RUNT**************************/
    
    public void  run(){
    
    	try {
    		
    		for(;;){
    			if (!gotWork) {
					getWork();
				}else {
					Random r = new Random(); 
	        		int color=r.nextInt(255)+1;
	                
	                double xx,yy;
	                int y;
	           		
	        		Tuple dataTuple;
	        		Tuple result;
	        		
	        		
	        		TupleSpace space1 = new TupleSpace("mBrot");
	        		
	        		Field fieldY= new Field (Integer.class);

	        		
	        		Tuple dataTemplate = new Tuple ("row");
	        		dataTemplate.add(fieldY);

	        		
	        		
	        		while (space1.countN(dataTemplate)>0){
	        			dataTuple = space1.waitToTake(dataTemplate);
	        			y=(Integer) dataTuple.getField(1).getValue();
	        	    	
	        			for (int x = 0; x < 20; x++) {
	        	           	
	        	            data[x] = color;
	        				
	        	        }
	        			 
	        			 
	        	  	    for (int x = 20; x < w.getWidth(); x++) {
	        	            
	        	        	xx=w.getxStart() + (w.getxEnd() - w.getxStart()) * x / (w.getWidth() - 1);
	        	            yy=w.getyStart() + (w.getyEnd() - w.getyStart()) * y / (w.getHeight() - 1);
	        	            data[x] = iterate(xx,yy)% 256;
	        	  	    
	        	         
	        	        }
	        	  	  result = new Tuple ("result",y,data);
	        	  	  space1.write(result);
	        	  	
	        		    		
	        		}
	        		
					
				}
    			
    			
    		}
    		
    		
    		
    		
    		
    	} catch (Exception e) { 
    		System.out.println("exception in run .....");
    		e.printStackTrace();
           
        }
    	
    }
    

    /*************ITERATE FUNCTION *********************************************/
    private int iterate(double x, double y) {
        int iter = 0;

        double aold = 0;
        double bold = 0;
        double a = 0;
        double b = 0;
        double asquared = a * a;
        double bsquared = b * b;

        a = x;
        b = y;

        double zsquared = asquared + bsquared;

        for (iter = 0; iter < w.getMaxIterations(); iter++) {
            a = asquared - bsquared + x;

            asquared = a * a;

            b = 2 * aold * b + y;

            if (bold == b && aold == a) {
                iter = w.getMaxIterations() - 1;
            }

            bsquared = b * b;

            zsquared = asquared + bsquared;

            if (zsquared > 4) {
                break;
            }

            bold = b;
            aold = a;
        }

        return iter;
    }
    
   
    
    public static void main(String[] args){
    	
    	//MandelWorker w = new MandelWorker();
    	//w.run();
    	Thread thread = new Thread(new MandelWorker());
      	thread.start();
     }

        
    }
	

