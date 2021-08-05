package kodlama.io.hrms.api.controllers;

import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import kodlama.io.hrms.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Result register(@Valid @RequestBody JobSeeker jobSeeker)  {
        return jobSeekerService.register(jobSeeker);
    }
    @PostMapping("login")
    public Result login(@Valid @RequestBody User user) {
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
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){

        Map<String,String> validationErrors=new HashMap<>();

        for (FieldError fieldError:exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> error=new ErrorDataResult<Object>(validationErrors,"Doğrulama Hatası");

        return error;
    }
}
