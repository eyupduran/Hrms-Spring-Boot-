package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.dataAccess.abstracts.CvDao;
import kodlama.io.hrms.entities.dtos.request.CvDto;

import java.util.List;

public interface CvService {
    DataResult<List<CvDto>> getAll();
    Result add(CvDto cvDto);
    Result delete(CvDto cvDto);

}
