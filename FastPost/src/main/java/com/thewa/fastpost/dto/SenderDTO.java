package com.thewa.fastpost.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SenderDTO {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private AddressDTO address;
	private String note;
}