package org.eshop.product.controller;

import org.eshop.product.model.businessLogic.manager.ProductManager;
import org.eshop.product.model.businessLogic.manager.impl.ProductManagerImpl;
import org.eshop.product.model.database.dataAccessObjects.ProductDAO;
import org.eshop.product.model.database.dataobjects.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class DeleteProductAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3666796923937616729L;

	public ResponseEntity<String> deleteProduct(String id) {

		ProductManager productManager = new ProductManagerImpl();

		Product product = productManager.getProductByName(id);

		if (product == null || product.getId() < 0) {
			return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);//Response.status(Status.NOT_FOUND).build();
		}
	
		ProductDAO pd = new ProductDAO();
		pd.deleteObject(product);		

		
		return new ResponseEntity<String>("".toString(), HttpStatus.OK);//Response.ok().build();
	}

}