package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    @Override
    public DataResult<List<Employer>> getAll() {

        return new SuccessDataResult<List<Employer>>(employerDao.findAll(),"iş verenler listelendi");
    }

    @Override
    public Result  register(Employer employer) {

        if(!validation(employer).isSuccess()) {
            return new ErrorResult(validation(employer).getMessage());
        }
        if(existEmail(employer.getEmail()).isSuccess()) {
            return new ErrorResult("Kullanıcı zaten kayıtlı");
        }

       employerDao.save(employer);

        return new SuccessResult("Kayıt Başarılı");

    }

    @Override
    public Result  login(String email, String password) {

        if(!existEmail(email).isSuccess()) {
            return new ErrorResult("Kullanıcı Bulunamadı");
        }

        Employer employer=(Employer) existEmail(email).getData();

        if(!employer.getPassword().equals(password)){
            return new ErrorResult("Şifre Yanlış");
        }


        return new SuccessResult("Giriş Başarılı");
    }


    @Override
    public Result update(Employer employer) {
        return new SuccessResult("Güncelleme Başarılı, Simülasyon");
    }

    @Override
    public Result delete(Employer employer) {
        this.employerDao.deleteById(employer.getId());
        return new SuccessResult("İş veren silindi");
    }

    @Override
    public Result validation(Employer employer) {
        if(employer.getPhone().length()!=11) {
            return new ErrorResult("telefon numarası 11 karakter olmalıdır");
        }
        else if(employer.getPassword().length()<3) {
            return new ErrorResult("şifre 3 karakterden çok olmalıdır");
        }
        return new SuccessResult();
    }
    public DataResult existEmail(String email) {
        Employer employer=employerDao.getByEmail(email);
        if(employer!=null){
            return new SuccessDataResult<Employer>(employer);
        }
        return new ErrorDataResult<Employer>(null,"Kullanıcı yok");
    }
}
