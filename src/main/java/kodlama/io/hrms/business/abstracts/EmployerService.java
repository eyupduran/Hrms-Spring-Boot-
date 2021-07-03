package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getAll();
    Result register(Employer employer);
    Result login(String email,String password);

    Result update(Employer employer);

    Result delete(Employer employer);
    Result validation(Employer employer);
}
