package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.CityService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.CityDao;
import kodlama.io.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {
   private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }


    @Override
    public Result add(City city) {
        this.cityDao.save(city);
        return new Result(true,"Şehir eklendi");
    }

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>(this.cityDao.findAll(),"Tüm şehirler listelendi");
    }

    @Override
    public Result delete(City city) {
        this.cityDao.delete(city);
        return new Result(true,"Şehir silindi");
    }

    @Override
    public Result update(City city) {
        return new Result(true,"Güncelleme başarılı, Simülasyon");
    }
}
