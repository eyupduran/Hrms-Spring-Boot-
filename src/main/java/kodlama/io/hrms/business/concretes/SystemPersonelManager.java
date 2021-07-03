package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.SystemPersonelService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.SystemPersonelDao;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.SystemPersonel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SystemPersonelManager implements SystemPersonelService {
    SystemPersonelDao systemPersonelDao;

    public SystemPersonelManager(SystemPersonelDao systemPersonelDao) {
        this.systemPersonelDao = systemPersonelDao;
    }

    @Override
    public DataResult<List<SystemPersonel>> getAll() {
        return new SuccessDataResult<List<SystemPersonel>>(systemPersonelDao.findAll(),"Sistem personelleri listelendi");
    }

    @Override
    public Result add(SystemPersonel systemPersonel) {
        this.systemPersonelDao.save(systemPersonel);
        return new SuccessResult("Sistem personeli eklendi");
    }

    @Override
    public Result update(SystemPersonel systemPersonel) {
        return null;
    }

    @Override
    public Result delete(SystemPersonel systemPersonel) {
        this.systemPersonelDao.deleteById(systemPersonel.getId());
        return new SuccessResult("Sistem kullanıcısı silindi");
    }
}
