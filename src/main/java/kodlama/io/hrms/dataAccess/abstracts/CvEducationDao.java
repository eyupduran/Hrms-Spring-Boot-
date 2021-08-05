package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.entities.concretes.CvEducation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvEducationDao extends JpaRepository<CvEducation,Integer> {
}
