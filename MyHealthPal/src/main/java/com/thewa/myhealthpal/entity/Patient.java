package com.thewa.myhealthpal.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String firstName;
	private String lastName;
	private String gender;
	private String birthDate;
	@NotNull
	private String contactInfo;
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	private List<MedicalHistory> medicalHistories;
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	private List<Appointment> appointments;
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	private List<Test> tests;
}