package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.entities.concretes.SystemPersonel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemPersonelDao extends JpaRepository<SystemPersonel,Integer> {
}
