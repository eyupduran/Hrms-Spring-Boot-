package kodlama.io.hrms.entities.concretes;

import lombok.*;

import java.util.Date;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jobPositions")
public class JobPosition {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id")
   private int id;
	@Column(name ="name")
   private String name;



}
