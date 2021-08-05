package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvSkill;

import java.util.List;

public interface CvSkillService {
    DataResult<List<CvSkill>> getAll();

    Result add(CvSkill cvSkill);

    Result delete(CvSkill cvSkill);

    Result update(CvSkill cvSkill);
}
