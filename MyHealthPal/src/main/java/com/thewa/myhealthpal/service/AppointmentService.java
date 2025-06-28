package com.thewa.myhealthpal.service;
import com.thewa.myhealthpal.entity.Appointment;
import com.thewa.myhealthpal.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	// Get all appointments
	public List<Appointment> getAllAppointments() {
		return appointmentRepository.findAll();
	}
	
	// Get appointments by doctor ID
	public List<Appointment> getAppointmentsByDoctorId(Long doctorId) {
		return appointmentRepository.findByDoctorId(doctorId);
	}
	
	// Get appointments by patient ID
	public List<Appointment> getAppointmentsByPatientId(Long patientId) {
		return appointmentRepository.findByPatientId(patientId);
	}
	
	// Add an appointment
	public Appointment addAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}
	
	// Update appointment details
	public Appointment updateAppointment(Long id, Appointment appointmentDetails) {
		Appointment appointment = appointmentRepository.findById(id).orElse(null);
		if (appointment != null) {
			appointment.setAppointmentDate(appointmentDetails.getAppointmentDate());
			appointment.setDoctor(appointmentDetails.getDoctor());
			appointment.setPatient(appointmentDetails.getPatient());
			return appointmentRepository.save(appointment);
		}
		return null;
	}
	
	// Delete appointment
	public void deleteAppointment(Long id) {
		appointmentRepository.deleteById(id);
	}
}