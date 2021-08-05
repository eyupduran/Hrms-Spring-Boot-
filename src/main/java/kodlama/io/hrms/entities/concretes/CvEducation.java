package kodlama.io.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cvEducation"})
@Table(name = "CvEducations")
public class CvEducation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotNull
    @NotBlank
    @Column(name = "schoolName")
    private String schoolName;
    @NotNull
    @NotBlank
    @Column(name = "department")
    private String department;
    @NotNull
    @NotBlank
    @Column(name = "startDate")
    private Date startDate;
    @Column(name = "graduationDate")
    private Date graduationDate;

//    @ManyToOne(targetEntity = Cv.class, fetch = FetchType.EAGER)
//    @JoinColumn(name = "cvId", insertable = false, updatable = false)
//    @JsonIgnore
//    private Cv cv;


}