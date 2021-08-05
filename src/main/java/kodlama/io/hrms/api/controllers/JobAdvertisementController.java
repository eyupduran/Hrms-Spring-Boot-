package kodlama.io.hrms.api.controllers;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.entities.dtos.request.JobAdvertisementDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementController {
    JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvertisement>> getAll() {
        return this.jobAdvertisementService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisementService.add(jobAdvertisement);
    }

    @GetMapping("/getByEmployerId")
    public DataResult getByEmployerId(int employerId) {
        return this.jobAdvertisementService.getByEmployerId(employerId);
    }

    @GetMapping("/getByCityName")
    public DataResult<List<JobAdvertisement>> getByCityName(String cityName) {
        return this.jobAdvertisementService.getByCityName(cityName);
    }

    @GetMapping("/getById")
    public DataResult<JobAdvertisement> getById(int id) {
        return this.jobAdvertisementService.getById(id);
    }

    @GetMapping("/getAllActiveJobAdvertList")
    public DataResult<List<JobAdvertisementDetailsDto>> getAllActiveJobAdvertList() {
        return this.jobAdvertisementService.getAllActiveJobAdvertList();
    }
    @GetMapping("/getAllActiveJobAdvertOrderByDateList")
    public DataResult<List<JobAdvertisementDetailsDto>> getAllActiveJobAdvertOrderByDateList() {
        return this.jobAdvertisementService.getAllActiveJobAdvertOrderByDateList();
    }
    @GetMapping("/getAllActiveJobAdvertListByEmployerId")
    public DataResult<List<JobAdvertisementDetailsDto>> getAllActiveJobAdvertListByEmployerId(int employerId) {
        return this.jobAdvertisementService.getAllActiveJobAdvertListByEmployerId(employerId);
    }
    @PostMapping("/updateActiveStatus")
    public Result updateActiveStatus( int id) {
        return this.jobAdvertisementService.updateActiveStatus(id);
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
