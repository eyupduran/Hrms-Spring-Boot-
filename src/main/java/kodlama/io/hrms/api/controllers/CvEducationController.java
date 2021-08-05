package kodlama.io.hrms.api.controllers;

import kodlama.io.hrms.business.abstracts.CvEducationService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvEducation;
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
@RequestMapping("/api/educations")
public class CvEducationController {

    private CvEducationService cvEducationService;

    @Autowired
    public CvEducationController(CvEducationService cvEducationService) {
        super();
        this.cvEducationService = cvEducationService;
    }

    @GetMapping("/getall")
    public DataResult<List<CvEducation>> getAll() {
        return cvEducationService.getAll();
    }

    @PostMapping("add")
    public Result add(@Valid @RequestBody CvEducation cvEducation){
        return cvEducationService.add(cvEducation);
    }

    @PostMapping("update")
    public Result update(@Valid @RequestBody CvEducation cvEducation) {
        return cvEducationService.update(cvEducation);
    }

    @PostMapping("delete")
    public Result delete(@RequestBody CvEducation cvEducation) {
        return cvEducationService.delete(cvEducation);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){

        Map<String,String> validationErrors=new HashMap<String,String>();

        for (FieldError fieldError:exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> error=new ErrorDataResult<Object>(validationErrors,"Doğrulama Hatası");

        return error;
    }

}
