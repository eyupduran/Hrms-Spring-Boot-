package kodlama.io.hrms.api.controllers;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.JobPosition;
import kodlama.io.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {
    private EmployerService employerService;
    @Autowired
    public EmployerController(EmployerService employerService) {
        super();
        this.employerService = employerService;
    }

    @GetMapping("/getall")
    public DataResult<List<Employer>> getAll() {
        return employerService.getAll();
    }
    @PostMapping("register")
    public Result register( Employer employer) {
        return employerService.register(employer);
    }
    @PostMapping("login")
    public Result login(User user) {
        return employerService.login(user.getEmail(),user.getPassword());
    }

    @PostMapping("update")
    public Result update(Employer employer) {
        return employerService.update(employer);
    }


    @PostMapping("delete")
    public Result delete(Employer entity) {
        return employerService.delete(entity);
    }

}
