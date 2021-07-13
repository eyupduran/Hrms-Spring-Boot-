package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.entities.dtos.request.JobAdvertisementDetailsDto;

import java.util.List;

public interface JobAdvertisementService {

    DataResult<List<JobAdvertisement>> getAll();

    Result add(JobAdvertisement jobAdvertisement);

    DataResult<JobAdvertisement> getByEmployerId(int employerId);

    DataResult<List<JobAdvertisement>> getByCityName(String cityName);

    DataResult<JobAdvertisement> getById(int id);

    DataResult<List<JobAdvertisementDetailsDto>> getAllActiveJobAdvertList();

    DataResult<List<JobAdvertisementDetailsDto>> getAllActiveJobAdvertOrderByDateList();

    DataResult<List<JobAdvertisementDetailsDto>> getAllActiveJobAdvertListByEmployerId(int employerId);

    Result updateActiveStatus(int id);
}
