/**
 * 
 */
package com.tk1.soap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.tu.model.ProductModel;
import com.tu.util.Util;

/**
 * @author Faisal Arshad
 *
 */
public class Products  {
	
	
	
	private static Products singleton = null;
	private  ArrayList<Product> availableProducts;
	private ArrayList<Product> orderList;
	private String status ;
	
	
	private Products(){ 
		this.setAvailableProducts(this.getAvailableProducts()); 
		
		Util.print("Products constructor......"+this.availableProducts.size());
		
	}
	   
	  
	   public static Products getInstance( ) {
		   if (singleton == null) {
			singleton = new Products();
		}
	      return singleton;
	   }
	  
	   

	public  ArrayList<Product> getAvailableProducts() {
		return ProductModel.getAvailableProducts();

	}
	
	public synchronized  Products  saveOrder(Products pro){
		Util.print("Inside Products save Order  . .. ..  .");
		List<Product> order = pro.getOrderList();
		HashMap<String, Product> productMap = new HashMap<String, Product>();
		 
		
		for (Product product : ProductModel.getAvailableProducts()) {
		   productMap.put(product.getPid(), product);
		}
		Util.print("available products  -- "+ProductModel.getAvailableProducts().size());
		for (Product prod : order) {
			if (null!=prod) {
				Product p = productMap.get(prod.getPid());
				if (null!=p) {
					Util.print(p.getQty()+"    "+prod.getQty());
					p.setQty(p.getQty()-prod.getQty());
					if (p.getQty() < 0) {
						this.setStatus("Product already Sold");
						Util.print("Product already Sold");
						return this;
					}else if(p.getQty() == 0) {
						ProductModel.getAvailableProducts().remove(p);
						
						Util.print("available products after remove -- "+ProductModel.getAvailableProducts().size());
					}else{
						
					productMap.put(p.getPid(), p);
					Set<String>keys = productMap.keySet();
					ArrayList<Product> list= new ArrayList<Product>();
					for (String key : keys) {
						list.add(productMap.get(key));
						
					}
					ProductModel.getAvailableProducts().addAll(list);
					
					Util.print("Quanity updated ....");
					}
				}else {
					Util.print("Product already Sold");
					this.setStatus("Product already Sold ");
					return this;
				}
			}
		}
		
		Util.print("returning from saveOrder soap success -- "+ProductModel.getAvailableProducts().size());
		this.setStatus("Success");
		return this;
		
	}


	public ArrayList<Product> getOrderList() {
		return orderList;
	}


	public void setOrderList(ArrayList<Product> orderList) {
		this.orderList = orderList;
		
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public void setAvailableProducts(ArrayList<Product> availableProducts) {
		this.availableProducts = availableProducts;
	}


	
	

	


	
	
	
}
