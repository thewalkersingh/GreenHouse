package com.thewa.fastpost.entity;
import com.thewa.fastpost.constant.PaymentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;
	@ManyToOne
	@JoinColumn(name = "sender_id", nullable = false)
	private Sender sender;
	@ManyToOne
	@JoinColumn(name = "receiver_id", nullable = false)
	private Receiver receiver;
	private BigDecimal amount;
	private String note;
	private String packageId;
	private LocalDateTime paymentDate;
}