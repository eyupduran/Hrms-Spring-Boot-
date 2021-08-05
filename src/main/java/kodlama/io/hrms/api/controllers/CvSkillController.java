package kodlama.io.hrms.api.controllers;

import kodlama.io.hrms.business.abstracts.CvSkillService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvSkill;
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
@RequestMapping("/api/skills")
public class CvSkillController {

    private CvSkillService cvSkillService;

    @Autowired
    public CvSkillController(CvSkillService cvSkillService) {
        this.cvSkillService = cvSkillService;
    }
    @GetMapping("/getAll")
    public DataResult<List<CvSkill>> getAll(){
        return this.cvSkillService.getAll();
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody CvSkill cvSkill){

        return this.cvSkillService.add(cvSkill);
    }
    @PostMapping("/delete")
    public Result delete(CvSkill cvSkill){

        return this.cvSkillService.delete(cvSkill);
    }

    @PostMapping("/update")
    public Result update(CvSkill cvSkill){

        return this.cvSkillService.update(cvSkill);
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
