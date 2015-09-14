/**
 * 
 */
package com.tk1.rest;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;

import com.tk1.soap.Products;
import com.tu.util.Util;

/**
 * @author Faisal Arshad
 *
 */

@Path("/restShop")
public class RestfulShopping {
  
 
    @POST
    @Path("/order/{o}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public String saveOrder( @PathParam("o") String p) {
    	
    	Products pr = null ;
    	String result = "";
    	ObjectMapper mapper =  new ObjectMapper();
    	try {
			
    		pr = mapper.readValue(p, Products.class);
    		Util.print(mapper.writeValueAsString(pr));
    		result = mapper.writeValueAsString(pr);
			Products pros =  Products.getInstance().saveOrder(pr);
		     result = mapper.writeValueAsString(pros);
		     
		     Util.print("after save order rest service");
		} catch (IOException e) {
			Util.print("Error in save order rest service ");
			e.printStackTrace();
		}
    	
    	Util.print("saveOrder --- "+result);
    	return result;
   }
    
    @POST
    @Path("/products")
    @Produces(MediaType.APPLICATION_JSON)
    public Products products() {

    	return Products.getInstance();
       
    }
}
