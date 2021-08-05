package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.CvSkillService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CvSkillDao;
import kodlama.io.hrms.entities.concretes.CvSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvSkillManager implements CvSkillService {
    private CvSkillDao cvSkillDao;

    @Autowired
    public CvSkillManager(CvSkillDao cvSkillDao) {
        this.cvSkillDao = cvSkillDao;
    }

    @Override
    public DataResult<List<CvSkill>> getAll() {
        return new SuccessDataResult<List<CvSkill>>(this.cvSkillDao.findAll(),"İşlem başarılı");
    }

    @Override
    public Result add(CvSkill cvSkill) {
        this.cvSkillDao.save(cvSkill);
        return new SuccessResult("Ekleme başarılı");
    }

    @Override
    public Result delete(CvSkill cvSkill) {
        this.cvSkillDao.delete(cvSkill);
        return new SuccessResult("Silme başarılı");
    }

    @Override
    public Result update(CvSkill cvSkill) {
        return null;
    }
}
