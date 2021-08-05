package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvJobExperience;

import java.util.List;

public interface CvJobExperienceService {
    DataResult<List<CvJobExperience>> getAll();

    Result add(CvJobExperience cvJobExperience);

    Result delete(CvJobExperience cvJobExperience);

    Result update(CvJobExperience cvJobExperience);
}
