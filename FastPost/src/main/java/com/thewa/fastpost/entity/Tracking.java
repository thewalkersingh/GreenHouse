package com.thewa.fastpost.entity;
import com.thewa.fastpost.constant.DeliveryStatus;
import com.thewa.fastpost.constant.TrackingType;
import com.thewa.fastpost.constant.VehicleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tracking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String trackingNumber;
	@Enumerated(EnumType.STRING)
	private TrackingType trackingType;
	private String currentLocation;
	@Embedded
	private Address destination;
	@Enumerated(EnumType.STRING)
	private DeliveryStatus deliveryStatus;
	private String vehicleNumber;
	@Enumerated(EnumType.STRING)
	private VehicleType vehicleType;
	private String driverNumber;
}