package com.thewa.fastpost.repository;
import com.thewa.fastpost.entity.Sender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SenderRepository extends JpaRepository<Sender, Long> {
	Optional<Sender> findByEmail(String email);
	
	Optional<Sender> findByPhone(String phone);
	
	Optional<Sender> findByEmailAndPhone(String email, String phone);

//	Optional<Sender> getSenderById(long id);
}