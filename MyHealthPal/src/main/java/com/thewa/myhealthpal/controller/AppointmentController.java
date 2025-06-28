package com.thewa.myhealthpal.controller;
import com.thewa.myhealthpal.entity.Appointment;
import com.thewa.myhealthpal.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;
	
	/**
	 * Get all appointments.
	 *
	 * @return List of appointments.
	 */
	@GetMapping
	public List<Appointment> getAllAppointments() {
		return appointmentService.getAllAppointments();
	}
	
	/**
	 * Get appointments by doctor ID.
	 *
	 * @param doctorId Doctor ID.
	 * @return List of appointments for the doctor.
	 */
	@GetMapping("/doctor/{doctorId}")
	public List<Appointment> getAppointmentsByDoctorId(@PathVariable Long doctorId) {
		return appointmentService.getAppointmentsByDoctorId(doctorId);
	}
	
	/**
	 * Get appointments by patient ID.
	 *
	 * @param patientId Patient ID.
	 * @return List of appointments for the patient.
	 */
	@GetMapping("/patient/{patientId}")
	public List<Appointment> getAppointmentsByPatientId(@PathVariable Long patientId) {
		return appointmentService.getAppointmentsByPatientId(patientId);
	}
	
	/**
	 * Add a new appointment.
	 *
	 * @param appointment Appointment object.
	 * @return Added Appointment object.
	 */
	@PostMapping
	public Appointment addAppointment(@RequestBody Appointment appointment) {
		return appointmentService.addAppointment(appointment);
	}
	
	/**
	 * Update an appointment.
	 *
	 * @param id          Appointment ID.
	 * @param appointment Appointment object with updated details.
	 * @return Updated Appointment object.
	 */
	@PutMapping("/{id}")
	public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
		return appointmentService.updateAppointment(id, appointment);
	}
	
	/**
	 * Delete an appointment by ID.
	 *
	 * @param id Appointment ID.
	 */
	@DeleteMapping("/{id}")
	public void deleteAppointment(@PathVariable Long id) {
		appointmentService.deleteAppointment(id);
	}
}