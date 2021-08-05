package kodlama.io.hrms.api.controllers;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.JobPosition;
import kodlama.io.hrms.entities.concretes.User;
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
    public Result register( @Valid @RequestBody  Employer employer) {
        return employerService.register(employer);
    }
    @PostMapping("login")
    public Result login(@Valid @RequestBody User user) {
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
