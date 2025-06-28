package com.thewa.fastpost.dto;
import com.thewa.fastpost.constant.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
	private Long id;
	private PaymentType paymentType;
	private Long senderId;
	private Long receiverId;
	private BigDecimal amount;
	private String note;
	private String packageId;
	private LocalDateTime paymentDate;
}