package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.CvJobExperienceService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CvJobExperienceDao;
import kodlama.io.hrms.entities.concretes.CvJobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CvJobExperienceManager implements CvJobExperienceService {
    private CvJobExperienceDao cvJobExperienceDao;

    @Autowired
    public CvJobExperienceManager(CvJobExperienceDao cvJobExperienceDao) {
        this.cvJobExperienceDao = cvJobExperienceDao;
    }


    @Override
    public DataResult<List<CvJobExperience>> getAll() {
        return new SuccessDataResult<List<CvJobExperience>>(this.cvJobExperienceDao.findAll(),"İşlem başarılı");
    }

    @Override
    public Result add(CvJobExperience cvJobExperience) {
        this.cvJobExperienceDao.save(cvJobExperience);
        return new SuccessResult("Ekleme başarılı");
    }

    @Override
    public Result delete(CvJobExperience CvJobExperience) {
        this.cvJobExperienceDao.delete(CvJobExperience);
        return new SuccessResult("Silme başarılı");
    }

    @Override
    public Result update(CvJobExperience CvJobExperience) {
        return null;
    }
}
