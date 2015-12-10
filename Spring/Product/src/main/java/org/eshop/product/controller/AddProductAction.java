package org.eshop.product.controller;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eshop.product.model.businessLogic.manager.ProductManager;
import org.eshop.product.model.businessLogic.manager.impl.ProductManagerImpl;
import org.eshop.product.model.database.dataobjects.Product;

public class AddProductAction {

	private static final long serialVersionUID = 39979991339088L;

	public Response addProduct(Product product) {

		if (!validate(product)) {
			return Response.status(Status.NOT_FOUND).build();
		}

		ProductManager productManager = new ProductManagerImpl();
		int productId = productManager.addProduct(product.getName(), product.getPrice(), product.getId(), product.getDetails());

		if (productId < 0) {
			return Response.status(Status.NOT_FOUND).build();
		}

		return Response.ok().build();
	}

	private boolean validate(Product product) {

		if(product == null){
			return false;
		}
		
		String id = product.getName();
		
		if (id == null || id.length() == 0) {
			return false;
		}

		if (product.getCategory() == null) {
			return false;
		}

		String price = String.valueOf(product.getPrice());
		if (price.length() > 0) {
			if (!price.matches("[0-9]+(.[0-9][0-9]?)?") || Double.parseDouble(price) < 0.0) {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}
}
