package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.CvEducationService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CvEducationDao;
import kodlama.io.hrms.entities.concretes.CvEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvEducationManager implements CvEducationService {

    private CvEducationDao cvEducationDao;

    public CvEducationManager(CvEducationDao cvEducationDao) {
        this.cvEducationDao = cvEducationDao;
    }

    @Override
    public DataResult<List<CvEducation>> getAll() {
        return new SuccessDataResult<List<CvEducation>>(this.cvEducationDao.findAll(),"İşlem başarılı");
    }

    @Override
    public Result add(CvEducation cvEducation) {
        this.cvEducationDao.save(cvEducation);
        return new SuccessResult("Ekleme başarılı");
    }

    @Override
    public Result delete(CvEducation cvEducation) {
        this.cvEducationDao.delete(cvEducation);
        return new SuccessResult("Silme başarılı");
    }

    @Override
    public Result update(CvEducation cvEducation) {
        return new SuccessResult("Güncelleme başarılı  : Simülasyon");
    }
}
