package kodlama.io.hrms.api.controllers;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.entities.dtos.request.JobAdvertisementDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
