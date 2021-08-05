package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvEducation;

import java.util.List;

public interface CvEducationService {
    DataResult<List<CvEducation>> getAll();

    Result add(CvEducation cvEducation);

    Result delete(CvEducation cvEducation);

    Result update(CvEducation cvEducation);


}
