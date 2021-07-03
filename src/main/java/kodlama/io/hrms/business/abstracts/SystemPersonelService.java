package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.SystemPersonel;

import java.util.List;

public interface SystemPersonelService {
    DataResult<List<SystemPersonel>> getAll();

    Result add(SystemPersonel systemPersonel);

    Result update(SystemPersonel systemPersonel);

    Result delete(SystemPersonel systemPersonel);

}
