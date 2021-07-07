package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.JobSeeker;

import java.util.List;

public interface JobSeekerService {
    DataResult<List<JobSeeker>> getAll();
    Result register(JobSeeker jobSeeker);
    Result login(String email, String password);
    Result existEmail(String email);
    Result update(JobSeeker jobSeeker);
    Result delete(JobSeeker jobSeeker);
    Result validation(JobSeeker jobSeeker);
}
