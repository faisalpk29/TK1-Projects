package com.tk1.util;

public class ProductNotFoundException extends Exception {
    
	private static final long serialVersionUID = 4173328143041925153L;
	public ProductNotFoundException(){}
    public ProductNotFoundException(String msg){
        super(msg);
    }
}
