package kodlama.io.hrms.entities.dtos.request;

import kodlama.io.hrms.entities.concretes.CvEducation;
import kodlama.io.hrms.entities.concretes.CvJobExperience;
import kodlama.io.hrms.entities.concretes.CvLanguage;
import kodlama.io.hrms.entities.concretes.CvSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CvDto {
    private int id;
    private int jobSeekerId;
    private String description;
    private List<CvEducation> cvEducations;
    private List<CvJobExperience> cvJobExperiences;
    private List<CvLanguage> cvLanguages;
    private List<CvSkill> cvSkills;

}
