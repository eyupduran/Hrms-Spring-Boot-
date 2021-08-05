package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.entities.concretes.CvSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvSkillDao extends JpaRepository<CvSkill,Integer> {
}
