package kodlama.io.hrms.api.controllers;

import kodlama.io.hrms.business.abstracts.SystemPersonelService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.SystemPersonel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public Result add(SystemPersonel systemPersonel){

        return this.systemPersonelService.add(systemPersonel);
    }
}
