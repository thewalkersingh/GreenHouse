package rent.history.checker.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "flats")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String address;
	private String city;
	private String state;
	private String flatType; // 2bhk, 3bhk
	private BigDecimal area; // in square meters
	private BigDecimal price; // in currency
	@Lob
	private String description;
	private boolean Available;
	
}