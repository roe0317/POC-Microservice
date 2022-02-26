package com.client.app;


import java.util.List;
import java.util.Scanner;

import org.springframework.web.client.RestTemplate;

import com.product.dto.ProductResponseDTO;
import com.product.dto.ResponseDTO;


public class MainApp {
//	private static final String GET_PRODUCT_ENDPOINT_URL = "http://localhost:8080/api/product";
//	private static final String GET_PRODUCTS_ENDPOINT_URL = "http://localhost:8080/api/product/{productId}";
//	private static final String CREATE_PRODUCT_ENDPOINT_URL = "http://localhost:8080/ecz/api/products/add";
//	private static final String UPDATE_PRODUCT_ENDPOINT_URL = "localhost:8080/ecz/api/product/{productId}";
//	private static final String DELETE_PRODUCT_ENDPOINT_URL = "localhost:8080/ecz/api//product/{productId}";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\n***************************************");
		System.out.println("    WELCOME TO POC APPLICATION");
		System.out.println("***************************************\n");
		
		System.out.println("[1] LIST OF AN ORDER");
		System.out.println("[2] ADDING AN ORDER");
		System.out.println("[3] BOOKING OF PRODUCTS");
		System.out.print("Please choose an option : ");
		int optionKey = scanner.nextInt();
		
		
		switch (optionKey) {
		case 1:
			getProductByAll();
			main(args);
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		default:
	
			break;
		}
		
	}
	
	
	public static void getProductByAll() {

		RestTemplate restTemplate = new RestTemplate();
		final String restApi = "http://localhost:8080/ecz/api/products";
		ProductResponseDTO service = restTemplate.getForObject(restApi, ProductResponseDTO.class);
		List<ResponseDTO> products = service.getList();
		for (ResponseDTO displayProduct : products) {	
//			System.out.println("Product ID       : " + displayProduct.getProductId());
			System.out.println("Product Brand    : " + displayProduct.getProductBrand());
			System.out.println("Product Name     : " + displayProduct.getProductName());
			System.out.println("Product Prize    : " + displayProduct.getProductPrice());
			System.out.println("Product Quantity : " + displayProduct.getProductQty());
		}
	}
	
	
	
}
