/**
 * 
 */
package com.tu.tk1;

import java.io.Serializable;

/**
 * @author Faisal Arshad
 *
 */
public class Work implements Serializable {
	
	
	private static final long serialVersionUID = 1487431411966482075L;
	private Double xStart;
	private Double xEnd;
	private Double yStart;
	private Double yEnd;
	private Integer width;
	private Integer height;
	private Integer maxIterations;
	
	
	
	public Work() {
		super();
		
	}



	/**
	 * @return the xStart
	 */
	public Double getxStart() {
		return xStart;
	}



	/**
	 * @param xStart the xStart to set
	 */
	public void setxStart(Double xStart) {
		this.xStart = xStart;
	}



	/**
	 * @return the xEnd
	 */
	public Double getxEnd() {
		return xEnd;
	}



	/**
	 * @param xEnd the xEnd to set
	 */
	public void setxEnd(Double xEnd) {
		this.xEnd = xEnd;
	}



	/**
	 * @return the yStart
	 */
	public Double getyStart() {
		return yStart;
	}



	/**
	 * @param yStart the yStart to set
	 */
	public void setyStart(Double yStart) {
		this.yStart = yStart;
	}



	/**
	 * @return the yEnd
	 */
	public Double getyEnd() {
		return yEnd;
	}



	/**
	 * @param yEnd the yEnd to set
	 */
	public void setyEnd(Double yEnd) {
		this.yEnd = yEnd;
	}



	/**
	 * @return the width
	 */
	public Integer getWidth() {
		return width;
	}



	/**
	 * @param width the width to set
	 */
	public void setWidth(Integer width) {
		this.width = width;
	}



	/**
	 * @return the height
	 */
	public Integer getHeight() {
		return height;
	}



	/**
	 * @param height the height to set
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}



	/**
	 * @return the maxIterations
	 */
	public Integer getMaxIterations() {
		return maxIterations;
	}



	/**
	 * @param maxIterations the maxIterations to set
	 */
	public void setMaxIterations(Integer maxIterations) {
		this.maxIterations = maxIterations;
	}



	
	
	
	
	
	
	
	
	
	

}
