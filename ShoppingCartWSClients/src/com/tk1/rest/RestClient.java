/**
 * 
 */
package com.tk1.rest;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.tk1.soap.Product;
import com.tk1.soap.Products;
import com.tk1.util.ClientInterface;
import com.tk1.util.Util;
 
public class RestClient {
    static final String REST_URI = "http://localhost:9999/calcrest";
    static final String ADD_PATH = "calc/add";
    static final String SUB_PATH = "calc/sub";
    static final String PRODUCTS_PATH = "calc/products";
    static ClientResponse response = null;
    public static void main(String[] args) {
 
    	JFrame mainFrame = new JFrame();        
    	mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
        ClientInterface mainPanel = new ClientInterface("rest");
        mainFrame.setTitle("Rest Client ");
        mainFrame.setResizable(false);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(mainPanel, BorderLayout.CENTER);
        mainFrame.pack();
        mainFrame.setVisible(true);  
        
        int a = 122;
        int b = 34;
 
        ClientConfig config = new DefaultClientConfig();
        
        Client client = Client.create(config);
       
    
        WebResource service = client.resource(REST_URI);
 
//        WebResource addService = service.path(ADD_PATH).path(a + "/" + b);
//        Util.print("Add Response: " + getResponse(addService));
//        Util.print("Add Output as XML: " + getOutputAsXML(addService));
//        Util.print("Add Output as Text: " + getOutputAsText(addService));
//        Util.print("---------------------------------------------------");
// 
//        WebResource subService = service.path(SUB_PATH).path(a + "/" + b);
//        Util.print("Sub Response: " + getResponse(subService));
//        Util.print("Sub Output as XML: " + getOutputAsXML(subService));
//        Util.print("---------------------------------------------------");
        
       
        
        
 
    }
 
//    private static String getResponseJSON(WebResource service)  {
//    	JSONObject obj = new JSONObject();
//    	response = service.accept(MediaType.APPLICATION_JSON).post(ClientResponse.class);
//    	Products p =response.getEntity(Products.class);
//    	
//    
//			List<Product> list = p.getAvailableProducts();
//	    	for (Product product : list) {
//				//product.getQty();
//				Util.print(product.getPname());
//			}
//		
//    	
//        return "";
//    }
    private static String getResponse(WebResource service) {
        return service.accept(MediaType.TEXT_XML).get(ClientResponse.class).toString();
    }
 
    private static String getOutputAsXML(WebResource service) {
        return service.accept(MediaType.TEXT_XML).get(String.class);
    }
 
    private static String getOutputAsText(WebResource service) {
        return service.accept(MediaType.TEXT_PLAIN).get(String.class);
    }
}
