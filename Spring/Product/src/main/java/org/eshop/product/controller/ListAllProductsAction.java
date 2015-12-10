package org.eshop.product.controller;

import org.eshop.product.model.businessLogic.manager.ProductManager;
import org.eshop.product.model.businessLogic.manager.impl.ProductManagerImpl;
import org.eshop.product.model.database.dataobjects.Product;

import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListAllProductsAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -94109228677381902L;
	
	
	public Response getProducts() {
		
		ProductManager productManager = new ProductManagerImpl();
		List<Product> productList = productManager.getProducts();
		
		if(productList == null){
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok(productList).build();
	}

}
