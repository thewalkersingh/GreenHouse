package rent.history.checker.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "issues")
public class Issue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "flat_id", nullable = false)
	private Flat flat;
	@Lob
	private String description;
	private LocalDate reportedDate;
	private LocalDate resolvedDate;
	private boolean isResolved;
}