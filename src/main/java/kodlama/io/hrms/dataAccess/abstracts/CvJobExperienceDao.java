package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.entities.concretes.CvJobExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvJobExperienceDao extends JpaRepository<CvJobExperience,Integer> {
}
