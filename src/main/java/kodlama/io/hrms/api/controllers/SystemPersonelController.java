package kodlama.io.hrms.api.controllers;

import kodlama.io.hrms.business.abstracts.SystemPersonelService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.SystemPersonel;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/systempersonels")
public class SystemPersonelController {
    SystemPersonelService systemPersonelService;

    public SystemPersonelController(SystemPersonelService systemPersonelService) {
        this.systemPersonelService = systemPersonelService;
    }
    @GetMapping("/getall")
    public DataResult<List<SystemPersonel>> getall(){

        return this.systemPersonelService.getAll();
    }
    @PostMapping("/add")
    public Result add(@Valid @RequestBody SystemPersonel systemPersonel){

        return this.systemPersonelService.add(systemPersonel);
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
