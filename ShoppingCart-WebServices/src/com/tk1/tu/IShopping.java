/**
 * 
 */
package com.tk1.tu;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import com.tk1.soap.Products;

/**
 * @author Faisal Arshad
 *
 */
@WebService
@SOAPBinding(style = Style.RPC ,use = Use.LITERAL)
public interface IShopping {
	@WebMethod Products saveOrder(@WebParam(name = "products")Products order);
	@WebMethod Products availableProducts();
	
}
