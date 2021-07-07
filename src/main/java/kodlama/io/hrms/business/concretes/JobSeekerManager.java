package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.dataAccess.abstracts.JobPositionDao;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {
    JobSeekerDao jobSeekerDao;

    @Autowired
    public JobSeekerManager( JobSeekerDao jobSeekerDao) {

        this.jobSeekerDao = jobSeekerDao;
    }


    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll(),"iş alanlar listelendi");
    }

    @Override
    public Result register(JobSeeker jobSeeker) {
        if(!validation(jobSeeker).isSuccess()) {
            return new ErrorResult(validation(jobSeeker).getMessage());
        }

        if(existEmail(jobSeeker.getEmail()).isSuccess()) {
            return new ErrorResult("Girmiş olduğunuz email sistmede zaten kayıtlı ");
        }
        if(existNatinalId(jobSeeker.getNationalIdentityNumber()).isSuccess()){
            return new ErrorResult("Bu kimlikli kişi kayıtlı");
        }

        jobSeekerDao.save(jobSeeker);

        return new SuccessResult("Kayıt Başarılı");
    }

    @Override
    public Result login(String email, String password) {

        if (!existEmail(email).isSuccess()) {
            return new ErrorResult("Kullanıcı Bulunamadı");
        }

        JobSeeker jobSeeker = (JobSeeker) existEmail(email).getData();

        if (!jobSeeker.getPassword().equals(password)) {
            return new ErrorResult("Şifre Yanlış");
        }


        return new SuccessResult("Giriş Başarılı");
    }


    @Override
    public Result update(JobSeeker jobSeeker) {
        return new SuccessResult("Güncelleme Başarılı ,simülasyon");
    }

    @Override
    public Result delete(JobSeeker jobSeeker) {
        this.jobSeekerDao.deleteById(jobSeeker.getId());
        return new SuccessResult("İş alan silindi");
    }

    @Override
    public Result validation(JobSeeker jobSeeker) {
        if(jobSeeker.getNationalIdentityNumber().length()!=11) {
            return new ErrorResult("kimlik numarası 11 karakter olmalıdır");
        }
        else if(jobSeeker.getPassword().length()>3) {
            return new ErrorResult("şifre 3 karakterden çok olmalıdır");
        }
        return new SuccessResult();
    }
    public DataResult existEmail(String email) {

        JobSeeker jobSeeker=jobSeekerDao.getByEmail(email);
        if(jobSeeker!=null){
            return new SuccessDataResult<JobSeeker>(jobSeeker);
        }
        return new ErrorDataResult<JobSeeker>(null,"Kullanıcı yok");
    }

    public Result existNatinalId(String nationalId) {

        boolean jobSeekerExist=jobSeekerDao.existsByNationalIdentityNumber(nationalId);
        if(jobSeekerExist){
            return new SuccessResult();
        }
        return new ErrorResult("Kullanıcı yok");
    }
}

