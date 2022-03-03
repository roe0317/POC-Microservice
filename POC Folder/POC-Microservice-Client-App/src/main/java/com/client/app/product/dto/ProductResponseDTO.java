package com.client.app.product.dto;

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
	
	
//	private List<RequestDTO> listOrdeRequestDTOs;
//	
//	public List<RequestDTO> getListFromUser(){
//		return listOrdeRequestDTOs;
//		
//	}
//	public void setDto(List<RequestDTO> requestDTOs) {
//		this.listOrdeRequestDTOs = requestDTOs;
//	}
	
	
	
}