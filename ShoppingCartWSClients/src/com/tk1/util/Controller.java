/**
 * 
 */
package com.tk1.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.xml.namespace.QName;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.tk1.soap.IShopping;
import com.tk1.soap.IShoppingImplService;
import com.tk1.soap.Product;
import com.tk1.soap.Products;

/**
 * @author Faisal Arshad
 *
 */
public class Controller {
	private String clientId;
	private URL url= null ; 
	private QName qname = null ; 
	IShoppingImplService service = null;
	IShopping port = null;
	ClientInterface gui ;
	
	private static final String REST_URI = "http://localhost:9999/shopping";
//	private static final String ADD_PATH = "restShop/add";
	private static final String ORDER_PATH = "restShop/order";
	private static final String PRODUCTS_PATH = "restShop/products";
	private static ClientResponse response = null;
    ClientConfig config = null;
    Client client = null;
    WebResource restService =null;
    WebResource proService =null;
    
	public Controller(String clientId,ClientInterface frontEnd){
		Util.print("Controller constructor .... "+clientId);
		this.gui = frontEnd;
		this.clientId = clientId;
		try {
			if (clientId.equals("soap")) {

				url = new URL("http://localhost:8090/shopping?wsdl");
				qname = new QName("http://tu.tk1.com/", "IShoppingImplService");
			    service = new IShoppingImplService(url, qname);
			    port = service.getPort(IShopping.class);

			} else {
				config = new DefaultClientConfig();
				client = Client.create(config);
				restService = client.resource(REST_URI);
			}

		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
	}
	public void getAvailableProducts(){
	
		if (this.clientId.equals("soap")) {
			Products available = port.availableProducts();
			List<Product> pr = available.getAvailableProducts();
			gui.updateTable(pr);
		}else{
		
		 	WebResource proService = restService.path(PRODUCTS_PATH);
		 	
	    	response = proService.accept(MediaType.APPLICATION_JSON).post(ClientResponse.class);
	    	Products p =response.getEntity(Products.class);
	    	List<Product> list = p.getAvailableProducts();
	    	
		    gui.updateTable(list);
		   
				
		}
		

		
		
	}
	 
	public  Products  saveOrder(Products pro)  {
	
	
		if (this.clientId.equals("soap")) {
			Products pros = port.saveOrder(pro);
			Util.print("returned from save order soap status -- "+ pros.getStatus());
			return pros;
			
			
		}else {
	
				Gson son =  new Gson();
				
				String d = son.toJson(pro);
				Util.print(d);
			WebResource proService = restService.path(ORDER_PATH).path(d);
			
			
	    	response = proService.accept(MediaType.APPLICATION_JSON).post(ClientResponse.class);
	    	
	    	Products pp = response.getEntity(Products.class);
	    	Util.print("--------"+pp.getStatus());
	    	return pp;
	    	
	    	//Util.print(p.getName()+"Status -- "+response.getStatus());
//	    	Products p =response.getEntity(Products.class);
		}
		
		
    }
	 

}
