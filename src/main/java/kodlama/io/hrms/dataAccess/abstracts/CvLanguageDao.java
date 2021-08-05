package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.entities.concretes.CvLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvLanguageDao extends JpaRepository<CvLanguage,Integer> {
}

