package kodlama.io.hrms.business.concretes;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobPositionService;
import kodlama.io.hrms.dataAccess.abstracts.JobPositionDao;
import kodlama.io.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition> > getAll() {

		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll(),"İş pozisyonları listelendi");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		if(this.jobPositionDao.existsJobPositionByName(jobPosition.getName())) {
			return new ErrorResult("Aynı isimden iş pozisyonu eklenemez ");
		}
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Ekleme başarılı");

	}

}
