package kodlama.io.hrms.api.controllers;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
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
	

}
