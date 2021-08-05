package kodlama.io.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CvJobExperiences")
@AllArgsConstructor
@NoArgsConstructor
public class CvJobExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "workingPlaceName")
    private String workingPlaceName;
    @Column(name = "positionName")
    private String positionName;
    @Column(name = "startDate")
    private Date startDate;
    @Column(name = "leavingDate")
    private Date leavingDate;

    @ManyToOne(targetEntity = Cv.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "cvId", insertable = false, updatable = false)
    @JsonIgnore
    private Cv cv;
}
