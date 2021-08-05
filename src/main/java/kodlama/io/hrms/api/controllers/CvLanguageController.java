package kodlama.io.hrms.api.controllers;

import kodlama.io.hrms.business.abstracts.CvLanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvLanguage;
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
@RequestMapping("/api/languages")
public class CvLanguageController {
    private CvLanguageService cvLanguageService;


    @Autowired
    public CvLanguageController(CvLanguageService cvLanguageService) {
        this.cvLanguageService = cvLanguageService;
    }

    @GetMapping("/getAll")
    public DataResult<List<CvLanguage>> getAll(){
        return this.cvLanguageService.getAll();
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody CvLanguage cvLanguage){

        return this.cvLanguageService.add(cvLanguage);
    }
    @PostMapping("/delete")
    public Result delete(CvLanguage cvLanguage){

        return this.cvLanguageService.delete(cvLanguage);
    }

    @PostMapping("/update")
    public Result update(CvLanguage cvLanguage){

        return this.cvLanguageService.update(cvLanguage);
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
