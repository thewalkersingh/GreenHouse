package rent.history.checker.entity;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String username;
	@NotBlank
	@Column(unique = true)
	private String telephone;
	@NotBlank
	private String password;
	@NotBlank
	private String name;
	private String address;
	@Email
	@NotBlank
	@Column(unique = true)
	private String email;
	private LocalDate dateOfBirth;
	private String role;
}