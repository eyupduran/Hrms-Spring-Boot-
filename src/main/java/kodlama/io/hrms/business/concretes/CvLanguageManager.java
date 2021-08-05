package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.CvLanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CvLanguageDao;
import kodlama.io.hrms.entities.concretes.CvLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvLanguageManager implements CvLanguageService {

    private CvLanguageDao cvLanguageDao;

    @Autowired
    public CvLanguageManager(CvLanguageDao cvLanguageDao) {
        this.cvLanguageDao = cvLanguageDao;
    }

    @Override
    public DataResult<List<CvLanguage>> getAll() {
        return new SuccessDataResult<List<CvLanguage>>(this.cvLanguageDao.findAll(),"İşlem başarılı");
    }

    @Override
    public Result add(CvLanguage cvLanguage) {
        this.cvLanguageDao.save(cvLanguage);
        return new SuccessResult("Ekleme başarılı");
    }

    @Override
    public Result delete(CvLanguage cvLanguage) {
        this.cvLanguageDao.delete(cvLanguage);
        return new SuccessResult("Silme başarılı");
    }

    @Override
    public Result update(CvLanguage cvLanguage) {
        return null;
    }
}
