package kodlama.io.hrms.api.controllers;

import kodlama.io.hrms.business.abstracts.CityService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.City;
import kodlama.io.hrms.entities.concretes.SystemPersonel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {
    private CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }
    @GetMapping("/getall")
    public DataResult<List<City>> getall(){

        return this.cityService.getAll();
    }
    @PostMapping("/add")
    public Result add(@RequestBody City city){

        return this.cityService.add(city);
    }
    @PostMapping("/delete")
    public Result delete(City city){

        return this.cityService.delete(city);
    }

    @PostMapping("/update")
    public Result update(City city){

        return this.cityService.update(city);
    }

}
