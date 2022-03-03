package com.product.service;

import java.util.List;

import com.product.Exception.ProductNotFoundException;
import com.product.model.Product;

public interface ProductService {
	
	public List<Product> getAllProducts();
	
	public Product getProductById(Long productId) throws ProductNotFoundException;
	
	public Product createProduct(Product product);
	
	public Product updateProduct(Long productId, Product product1) throws ProductNotFoundException;
	
	public void deleteProduct(Long productId) throws ProductNotFoundException;
	
}
