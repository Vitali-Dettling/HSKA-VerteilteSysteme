package org.eshop.product.controller;

import org.eshop.product.model.businessLogic.manager.ProductManager;
import org.eshop.product.model.businessLogic.manager.impl.ProductManagerImpl;
import org.eshop.product.model.database.dataobjects.Product;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class DeleteProductAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3666796923937616729L;

	public Response deleteProduct(String id) {

		ProductManager productManager = new ProductManagerImpl();

		Product product = productManager.getProductByName(id);

		if (product == null || product.getId() < 0) {
			return Response.status(Status.NOT_FOUND).build();
		}

		productManager.deleteProductById(product.getId());

		return Response.ok().build();
	}

}
