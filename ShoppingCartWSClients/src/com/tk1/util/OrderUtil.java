package com.tk1.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import com.tk1.soap.Product;

public class OrderUtil {

	
	 public OrderUtil(String uid, HashMap<String, Product> orderMap) {
		super();
		this.uid = uid;
		this.orderMap = orderMap;
	}
	public String uid;
	private HashMap<String,Product> orderMap;
	 
	public boolean addProduct(Product p){
        if(orderMap.containsKey(p.getPid())){
            Product p1 =(Product) orderMap.get(p.getPid());
            double price = p.getPrice() * p.getQty();
            p1.setPrice(p1.getPrice()+price);
            p1.setQty(p1.getQty()+p.getQty());
            return true;
        }
        
        p.setPrice(p.getPrice()*p.getQty());
        orderMap.put(p.getPid(),p);
        return false;
    }//addProduct
 
    public Product removeProduct(String pid)
    throws ProductNotFoundException {
        if(orderMap.containsKey(pid)){
        	Product p = orderMap.get(pid);
            orderMap.remove(pid);
            return p;
        }else throw new ProductNotFoundException(
      "Product with ID "+pid+" is not Found.");
    }
 
    public Collection<Product> getCartDetails(){
        return orderMap.values();
    }
 
    public Product getProductFromCart(String pid)
    throws ProductNotFoundException {
        if(orderMap.containsKey(pid)){
            return (Product)orderMap.get(pid);
        }else {
            throw new ProductNotFoundException(
        "Product with ID "+pid+" is not Found.");
        }
    }
 
    public int productCount(){
        return orderMap.size();
    }
 
  public double getCartPrice() {
	 double cartPrice = 0.0d;
    Iterator<Product> iterator = getCartDetails().iterator();
    while(iterator.hasNext()){
    	cartPrice+= ((Product) iterator.next()).getPrice();
    }
    
    return cartPrice;
  }
public HashMap<String, Product> getOrderMap() {
	return orderMap;
}
public void setOrderMap(HashMap<String, Product> orderMap) {
	this.orderMap = orderMap;
}
}
