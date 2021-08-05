package kodlama.io.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Null;

@Entity
@Table(name = "CvSkills")
@AllArgsConstructor
@NoArgsConstructor
public class CvSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "softwareTechnologyName")
    private String softwareTechnologyName;

    @Column(name = "cvId")
    private int cvId;

    @ManyToOne(targetEntity = Cv.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "cvId", insertable = false, updatable = false)
    @JsonIgnore
    private Cv cv;


}
