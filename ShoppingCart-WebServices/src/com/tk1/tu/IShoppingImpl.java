/**
 * 
 */
package com.tk1.tu;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import com.tk1.soap.Products;

/**
 * @author Faisal Arshad
 *
 */
@WebService(endpointInterface = "com.tk1.tu.IShopping")
@SOAPBinding(style = Style.RPC ,use = Use.LITERAL)
public class IShoppingImpl implements IShopping {

	
	@Override
	public Products saveOrder(Products order) {
		
		Products p =  Products.getInstance();
		return p.saveOrder(order);
		
	}

	@Override
	public Products availableProducts() {
		return Products.getInstance();
		
	}

	

}
