package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.core.utilities.results.*;
import kodlama.io.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.entities.dtos.request.JobAdvertisementDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
    private JobAdvertisementDao jobAdvertisementDao;
    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao){
        this.jobAdvertisementDao=jobAdvertisementDao;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll(),"Tüm iş ilanları listelendi");
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
       /* if(this.jobAdvertisementDao.getByIsActive(jobAdvertisement.isActive())){
        }*/
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new Result(true,"İş ilanı eklendi");
    }
    public DataResult<JobAdvertisement> getByEmployerId(int employerId){
        return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getByEmployerId(employerId),"İşlem başarılı");
    }
    public DataResult<List<JobAdvertisement>> getByCityName(String cityName){
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByCity_Name(cityName),"İşlem başarılı");
    }

    @Override
    public DataResult<JobAdvertisement> getById(int Id) {
        return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getById(Id),"işlem başarılı");
    }

    @Override
    public DataResult<List<JobAdvertisementDetailsDto>> getAllActiveJobAdvertList() {
        return new SuccessDataResult<List<JobAdvertisementDetailsDto>>(this.jobAdvertisementDao.getAllActiveJobAdvertList(),"Aktif tüm iş ilanları listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisementDetailsDto>> getAllActiveJobAdvertOrderByDateList() {
        return new SuccessDataResult<List<JobAdvertisementDetailsDto>>(this.jobAdvertisementDao.getAllActiveJobAdvertOrderByDateList(),"Aktif tüm iş ilanları tarihe göre sıralandı");
    }

    @Override
    public DataResult<List<JobAdvertisementDetailsDto>> getAllActiveJobAdvertListByEmployerId(int employerId) {
        return new SuccessDataResult<List<JobAdvertisementDetailsDto>>(this.jobAdvertisementDao.getAllActiveJobAdvertListByEmployerId(employerId),"Firmaya ait aktif tüm iş ilanları getirildi");
    }

}
