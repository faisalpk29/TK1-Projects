/**
 * 
 */
package com.tu.model;

import java.util.ArrayList;
import java.util.Random;

import com.tk1.soap.Product;

/**
 * @author Faisal Arshad
 *
 */
public class ProductModel {
	private static ArrayList<Product> availableProducts ;
	
	static {
		fillModel();
	}

	static void fillModel() {
		availableProducts = new ArrayList<Product>();
		Random r = new Random(5000);
		
		
		double price =2500;
		for (int i = 1; i < 20; i++) {
			Product p = new Product();
			p.setPid("P"+i);
			p.setPname("Product " + i);
			
			p.setPrice(price + r.nextDouble());
			p.setQty(i + 1);
			availableProducts.add(p);

		}

	}

	public static ArrayList<Product> getAvailableProducts() {
		return availableProducts;
	}

	
	

}
