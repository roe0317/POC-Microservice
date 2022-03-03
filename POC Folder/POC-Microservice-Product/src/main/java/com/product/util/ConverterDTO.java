package com.product.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.product.dto.RequestDTO;
import com.product.dto.ResponseDTO;
import com.product.model.Product;

@Component
public class ConverterDTO {
	
	//Converted Producted!
	public ResponseDTO convertEntity(Product product) {
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setProductId(product.getProductId());
		responseDTO.setProductBrand(product.getProductBrand());
		responseDTO.setProductName(product.getProductName());
		responseDTO.setProductPrice(product.getProductPrice());
		responseDTO.setProductQty(product.getProductQty());
		return responseDTO;
	}
	
	//Converted RequestDTO
	public Product convertProductDto(RequestDTO requestDTO) {
		Product product = new Product();
		product.setProductId(product.getProductId());
		product.setProductBrand(requestDTO.getProductBrand());
		product.setProductName(requestDTO.getProductName());
		product.setProductPrice(requestDTO.getProductPrice());
		product.setProductQty(requestDTO.getProductQty());	
		return product;	
	}
	
	//Converted ResponseDTO List!
	public List<ResponseDTO> convertEntity(List<Product> products){
		return products
				.stream()
				.map(this::convertEntity)
				.collect(Collectors.toList());
	}

	
}
