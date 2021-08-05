package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.*;

import kodlama.io.hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.CvDao;

import kodlama.io.hrms.entities.dtos.request.CvDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CvManager implements CvService {
    private CvDao cvDao;
   // private final DtoConverterService dtoConverterService;
    private CvEducationService cvEducationService;
    private CvJobExperienceService cvJobExperienceService;
    private CvLanguageService cvLanguageService;
    private CvSkillService cvSkillService;

    @Autowired
    public CvManager(CvDao cvDao, CvEducationService cvEducationService, CvJobExperienceService cvJobExperienceService, CvLanguageService cvLanguageService, CvSkillService cvSkillService) {
        this.cvDao = cvDao;
        this.cvEducationService = cvEducationService;
        this.cvJobExperienceService = cvJobExperienceService;
        this.cvLanguageService = cvLanguageService;
        this.cvSkillService = cvSkillService;
    }


    @Override
    public DataResult<List<CvDto>> getAll() {
        return null;
    }

    @Override
    public Result add(CvDto cvDto) {
        return null;
    }

    @Override
    public Result delete(CvDto cvDto) {
        return null;
    }

}
