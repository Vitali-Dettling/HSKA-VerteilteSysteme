package org.eshop.product.controller;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eshop.product.model.businessLogic.manager.ProductManager;
import org.eshop.product.model.businessLogic.manager.impl.ProductManagerImpl;
import org.eshop.product.model.database.dataobjects.Product;

public class GetProductAction {
	
	private static final long serialVersionUID = 39979991339088L;

	public Response getProductById(String id) {

		ProductManager productManager = new ProductManagerImpl();

		Product product = productManager.getProductByName(id);
		
		if(product == null){
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok(product).build();
	}

	
	
	
}
