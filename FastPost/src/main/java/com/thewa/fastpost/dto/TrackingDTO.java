package com.thewa.fastpost.dto;
import com.thewa.fastpost.constant.DeliveryStatus;
import com.thewa.fastpost.constant.TrackingType;
import com.thewa.fastpost.constant.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackingDTO {
	private Long id;
	private String trackingNumber;
	private TrackingType trackingType;
	private String currentLocation;
	private AddressDTO destination;
	private DeliveryStatus deliveryStatus;
	private VehicleType vehicleType;
	private String vehicleNumber;
	private String driverNumber;
}