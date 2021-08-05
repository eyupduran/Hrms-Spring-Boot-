package kodlama.io.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Cvs")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cv"})
public class Cv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "linkedinAdress")
    private String linkedinAdress;
    @Column(name = "githubAdress")
    private String githubAdress;
    @Column(name = "description")
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "cv")
    List<CvJobExperience> cvJobExperiences;

    @JsonIgnore
    @OneToMany(mappedBy = "cv")
    List<CvLanguage> cvLanguages;

    @JsonIgnore
    @OneToMany(mappedBy = "cv")
    List<CvSkill> cvSkills;

//    @JsonIgnore
//    @OneToMany(mappedBy = "cv")
//    List<CvEducation> cvEducations;

    @ManyToOne
    @JoinColumn(name = "jobSeekerId")
    private JobSeeker jobSeeker;

}
