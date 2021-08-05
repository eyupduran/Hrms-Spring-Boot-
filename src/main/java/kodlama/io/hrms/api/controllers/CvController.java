package kodlama.io.hrms.api.controllers;

import kodlama.io.hrms.business.abstracts.CvService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.dtos.request.CvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cvs")
public class CvController {
    private CvService cvService;

    @Autowired
    public CvController(CvService cvService) {
        this.cvService = cvService;
    }

    @GetMapping("/getall")
    public DataResult<List<CvDto>> getall(){

        return this.cvService.getAll();
    }
    @PostMapping("/add")
    public Result add(CvDto cvDto){

        return this.cvService.add(cvDto);
    }
    @PostMapping("/delete")
    public Result delete( CvDto cvDto){

        return this.cvService.delete(cvDto);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {

        Map<String, String> validationErrors = new HashMap<>();

        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> error = new ErrorDataResult<Object>(validationErrors, "Doğrulama Hatası");

        return error;
    }
}
