package com.thewa.fastpost.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
	private Long id;
	private String address;
	private String city;
	private String state;
	private String zip;
}