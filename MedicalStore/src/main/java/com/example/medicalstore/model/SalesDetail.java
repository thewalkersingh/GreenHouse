package com.example.medicalstore.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SalesDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int saleId;
	private int medicineId;
	private int quantity;
	private double totalPrice;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getMedicineId() {
		return medicineId;
	}
	
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}
	
	public int getSaleId() {
		return saleId;
	}
	
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}