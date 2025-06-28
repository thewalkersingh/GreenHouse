package com.thewa.fastpost.repository;
import com.thewa.fastpost.entity.Receiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReceiverRepository extends JpaRepository<Receiver, Long> {
	Optional<Receiver> findByFirstName(String firstName);
	
	Optional<Receiver> findByEmail(String email);
	
	Receiver findByPhone(String phone);
	
	Receiver findByEmailAndPhone(String email, String phone);
	
	Receiver getReceiversById(long id);
}