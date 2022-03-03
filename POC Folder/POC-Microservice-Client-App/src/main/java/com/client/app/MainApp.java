package com.client.app;

import java.util.List;
import java.util.Scanner;

import org.springframework.web.client.RestTemplate;

import com.client.app.product.dto.ProductResponseDTO;
import com.client.app.product.dto.RequestDTO;
import com.client.app.product.dto.ResponseDTO;
import com.exception.product.ProductNotFoundException;


public class MainApp {

	public static void main(String[] args) {
		product();
	}
	
	
	
	public static void product() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\n***************************************");
		System.out.println("    WELCOME TO POC APPLICATION");
		System.out.println("***************************************\n");
		
		System.out.println("[1] LIST OF PRODUCTS");
		System.out.println("[2] ADDING A PRODUCT");
		System.out.println("[3] BOOKING OF PRODUCTS");
		System.out.print("Please choose an option : ");
		int optionKey = scanner.nextInt();
		
		
		switch (optionKey) {
		case 1:
			
			System.out.println("\n***************************************");
			System.out.println("          LIST OF PRODUCTS    ");
			System.out.println("***************************************\n");		
			listProduct();
			
			
			break;
		case 2:
			System.out.println("\n***************************************");
			System.out.println("          CREATE OF PRODUCTS    ");
			System.out.println("***************************************\n");
			
			adding();
			product();
			break;
		case 3:
			break;
		default:
	
			break;
		}
		
	}
	
	
	
	//Product Listing UI
	
	public static void listProduct() {
		
		System.out.println("[1] PER PRODUCTS");
		System.out.println("[2] ALL PRODUCTS");
		
		System.out.print("CHOOSE : ");
		int key = new Scanner(System.in).nextInt();
		
		if (key == 1) {
			System.out.println("\n***************************************");
			System.out.println("          LIST OF PRODUCTS    ");
			System.out.println("***************************************\n");
			
			try {
				updateById();
			} catch (ProductNotFoundException e) {
				e.printStackTrace();
			}
		} else if (key == 2) {
			
			System.out.println("\n***************************************");
			System.out.println("          LIST OF PRODUCTS    ");
			System.out.println("***************************************\n");
			getProductByAll();
		} else {
			System.out.println("Invalid Input!");
			product();
		}
	}
	
	//enable to see the product that was list on file!
	public static void getProductByAll() {

	
		RestTemplate restTemplate = new RestTemplate();
		final String restApi = "http://localhost:8080/ecz/api/products";
		ProductResponseDTO service = restTemplate.getForObject(restApi, ProductResponseDTO.class);
		List<ResponseDTO> products = service.getList();
		for (ResponseDTO displayProduct : products) {	
			System.out.println("\nProduct ID       : " + displayProduct.getProductId());
			System.out.println("Product Brand    : " + displayProduct.getProductBrand());
			System.out.println("Product Name     : " + displayProduct.getProductName());
			System.out.println("Product Prize    : " + displayProduct.getProductPrice());
			System.out.println("Product Quantity : " + displayProduct.getProductQty() + "\n");
		}
		
		
		System.out.println("\n[1] MENU" + "\t" + "[2] BACK" + "\n");
		System.out.print("ANSWER : ");
		int options = new Scanner(System.in).nextInt();
		
		switch (options) {
		case 1:
			System.out.println();
			product();
			break;
			
		case 2:
			System.out.println();
			listProduct();
			break;

		default:
			break;
		}
		
	}
	
	//enable to user add a product to the database!
	public static void adding() {
		
		System.out.print("\nENTER PROUCT BRAND    : ");
		String brand = new Scanner(System.in).next(); 
		
		System.out.print("ENTER PROUCT NAME     : ");
		String name = new Scanner(System.in).next(); 
		
		System.out.print("ENTER PROUCT PRIZE    : ");
		float prize = new Scanner(System.in).nextFloat(); 
		
		System.out.print("ENTER PROUCT QUANTITY : ");
		int qty = new Scanner(System.in).nextInt(); 

		RequestDTO request = new RequestDTO();
		request.setProductBrand(brand);
		request.setProductName(name);
		request.setProductPrice(prize);
		request.setProductQty(qty);

		System.out.println("\nProduct Brand   : " + request.getProductBrand());
		System.out.println("Product Name    : " + request.getProductName());
		System.out.println("Product Price   : " + request.getProductPrice());
		System.out.println("Product Quanity : " + request.getProductQty());
		
		System.out.println("/Would you like to save on file? [Y] || [N]");
		System.out.print("ANSWER : ");
		String optionKey = new Scanner(System.in).next();
		
		switch (optionKey.toLowerCase()) {
		case "y":
			RestTemplate restTemplate = new RestTemplate();
			final String restApi = "http://localhost:8080/ecz/api/products/add";
			restTemplate.postForObject(restApi, request, ProductResponseDTO.class);
			break;
			
		case "n":
			main(null);
			break;
			
		default:
			break;
		}
	}
	
	//Get ID and Update Static Method
	
	private final static String PRODUCT_URL = "http://localhost:8080/ecz/api/";
	private static final RestTemplate productsRestTemplate = new RestTemplate();

	public static void updateById() throws ProductNotFoundException {

		System.out.println();
		System.out.println("ENTER THE PRODUCT ID");
		System.out.print("ANSWER : ");
		Long searchId = new Scanner(System.in).nextLong();
		
		ProductResponseDTO productResponse = productsRestTemplate.getForObject(PRODUCT_URL+"/productDTO/"+searchId, ProductResponseDTO.class);
		ResponseDTO dto = productResponse.getResponseDTO();

		System.out.println("\nProduct Brand   : " + dto.getProductBrand());
		System.out.println("Product Name    : " + dto.getProductName());
		System.out.println("Product Price   : " + dto.getProductPrice());
		System.out.println("Product Quanity : " + dto.getProductQty());
		
		System.out.println("WOULD YOU LIKE TO UPDATE? [Y] || [N] \n");
		System.out.print("ANSWER : ");
		String key = new Scanner(System.in).next();
		
		
		if (key.equalsIgnoreCase("y")) {
			
			System.out.println("[1] PRODUCT BRAND");
			System.out.println("[2] PRODUCT NAME");
			System.out.println("[3] PRODUCT PRICE");
			System.out.println("[4] PRODUCT QUANTITY");
			
			System.out.print("Please choose an option : ");
			int optionKey = new Scanner(System.in).nextInt();
			
			
			
			switch (optionKey) {
			case 1:
				System.out.println("Enter Product Brand : ");
				System.out.print("ANSWER : ");
				String productBrand = new Scanner(System.in).next();
				String api1 = "http://localhost:8080/ecz/api/product/"+searchId;
				RestTemplate restTemplate1 = new RestTemplate();
				dto.setProductBrand(productBrand);
				restTemplate1.put(api1, dto, ResponseDTO.class);
				updateById();
				break;

			case 2:
				System.out.println("Enter Product Name : ");
				System.out.print("ANSWER : ");
				String productName = new Scanner(System.in).next();
				String api2 = "http://localhost:8080/ecz/api/product/"+searchId;
				RestTemplate restTemplate2 = new RestTemplate();
				dto.setProductName(productName);
				restTemplate2.put(api2, dto, ResponseDTO.class);
				updateById();
				break;
				
			case 3:
				System.out.println("Enter Product Price : ");
				System.out.print("ANSWER : ");
				float productPrice = new Scanner(System.in).nextFloat();
				String api3 = "http://localhost:8080/ecz/api/product/"+searchId;
				RestTemplate restTemplate3 = new RestTemplate();
				dto.setProductPrice(productPrice);
				restTemplate3.put(api3, dto, ResponseDTO.class);
				System.out.println("Successfully Updated!");
				updateById();
				break;
			case 4:
				System.out.println("Enter Product Quantity : ");
				System.out.print("ANSWER : ");
				int productQty = new Scanner(System.in).nextInt();
				String api4 = "http://localhost:8080/ecz/api/product/"+searchId;
				RestTemplate restTemplate4 = new RestTemplate();
				dto.setProductQty(productQty);
				restTemplate4.put(api4, dto, ResponseDTO.class);
				System.out.println("Successfully Updated!");
				updateById();
				break;
			default:
				System.out.println("Invalid Input");
				updateById();
				break;
			}
		} else {
			System.out.println("Thank you!");
			product();
		}
		
	}
		
}

