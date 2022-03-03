package com.product.dto;

import java.util.List;

public class ProductResponseDTO {
	private List<ResponseDTO> list;
	
	public List<ResponseDTO> getList(){
		return list;
	}
	
	public void setDTo(List<ResponseDTO> responseDTOs) {
		this.list = responseDTOs;
	}
	
	
	
	
	
	private ResponseDTO dto;
	
	
	public ResponseDTO getResponseDTO() {
		return dto;
	}
	
	public void setResponseDTO(ResponseDTO responseDTO) {
		this.dto = responseDTO;
	}
	
	
	
	
	
	
	
	
}