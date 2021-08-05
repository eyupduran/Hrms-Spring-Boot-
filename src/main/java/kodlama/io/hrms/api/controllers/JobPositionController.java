package kodlama.io.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import kodlama.io.hrms.business.abstracts.JobPositionService;
import kodlama.io.hrms.entities.concretes.JobPosition;


@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionController {
	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	};
	
	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll(){

		return this.jobPositionService.getAll();
	}

	@PostMapping("/add")
	public Result add( @RequestBody  JobPosition jobPosition){
		return this.jobPositionService.add(jobPosition);
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
