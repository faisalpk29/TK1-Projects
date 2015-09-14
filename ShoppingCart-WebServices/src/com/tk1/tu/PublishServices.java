/**
 * 
 */
package com.tk1.tu;

import java.io.IOException;

import javax.xml.ws.Endpoint;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;
import com.tu.util.Util;

/**
 * @author Faisal Arshad
 *
 */
public class PublishServices {
	static final String BASE_URI = "http://localhost:9999/shopping/";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
            HttpServer server = HttpServerFactory.create(BASE_URI);
            Endpoint ep= Endpoint.publish("http://localhost:8090/shopping", new IShoppingImpl());
    		Util.print("JAX WS Service started : "+ep.isPublished());
            server.start();
            Util.print("Rest Service started successfully ....");
            System.in.read();
            server.stop(0);
            ep.stop();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
}
