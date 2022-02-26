package com.client.app;

import java.util.List;
import java.util.Scanner;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.product.dto.ProductResponseDTO;
import com.product.dto.RequestDTO;
import com.product.dto.ResponseDTO;


public class MainApp {

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
			adding();
			main(args);
			break;
		case 3:
			
			break;
		default:
	
			break;
		}
		
	}
	
	
	public static void getProductByAll() {
		
		
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
		
		RestTemplate restTemplate = new RestTemplate();
		final String restApi = "http://localhost:8080/ecz/api/products";
		ProductResponseDTO service = restTemplate.getForObject(restApi, ProductResponseDTO.class);
		List<ResponseDTO> products = service.getList();
		for (ResponseDTO displayProduct : products) {	

			System.out.println("\nProduct Brand    : " + displayProduct.getProductBrand());
			System.out.println("Product Name     : " + displayProduct.getProductName());
			System.out.println("Product Prize    : " + displayProduct.getProductPrice());
			System.out.println("Product Quantity : " + displayProduct.getProductQty() + "\n");
		}
	}
	
	public static void adding() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		final String restApi = "http://localhost:8080/ecz/api/products/add";
		
		System.out.print("\nENTER PROUCT BRAND  : ");
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
//		HttpEntity<RequestDTO> httpEntity = new HttpEntity<>(request, headers);
		System.out.println("Product Brand   : " + request.getProductBrand());
		System.out.println("Product Name    : " + request.getProductName());
		System.out.println("Product Price   : " + request.getProductPrice());
		System.out.println("Product Quanity : " + request.getProductQty());
		
		System.out.println("Would you like to save on file? [Y] || [N]");
		String optionKey = new Scanner(System.in).next();
		
		switch (optionKey.toLowerCase()) {
		case "y":
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.postForObject(restApi, request, ProductResponseDTO.class);
			break;
			
		case "n":
			main(null);
			break;
			
		default:
			break;
		}
		
			
	}
}
