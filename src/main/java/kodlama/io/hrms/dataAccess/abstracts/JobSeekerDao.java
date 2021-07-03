package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerDao extends JpaRepository<JobSeeker,Integer> {
    JobSeeker getByEmail(String email);

    boolean existsByNationalIdentityNumber(String nationalIdentityNumber);

}
