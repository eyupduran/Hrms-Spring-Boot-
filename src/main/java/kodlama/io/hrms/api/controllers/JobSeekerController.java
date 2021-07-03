package kodlama.io.hrms.api.controllers;

import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import kodlama.io.hrms.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekerController {
    private JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekerController(JobSeekerService jobSeekerService) {
        super();
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobSeeker>> getAll() {
        return jobSeekerService.getAll();
    }
    @PostMapping(  "register")
    public Result register(  JobSeeker jobSeeker)  {
        return jobSeekerService.register(jobSeeker);
    }
    @PostMapping("login")
    public Result login(User user) {
        return jobSeekerService.login(user.getEmail(),user.getPassword());
    }


    @PostMapping("update")
    public Result update(JobSeeker jobSeeker) {
        return jobSeekerService.update(jobSeeker);
    }


    @PostMapping("delete")
    public Result delete(JobSeeker jobSeeker) {
        return jobSeekerService.delete(jobSeeker);
    }
}
