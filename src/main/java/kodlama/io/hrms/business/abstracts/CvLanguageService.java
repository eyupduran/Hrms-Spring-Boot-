package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CvLanguage;

import java.util.List;

public interface CvLanguageService {
    DataResult<List<CvLanguage>> getAll();

    Result add(CvLanguage cvLanguage);

    Result delete(CvLanguage cvLanguage);

    Result update(CvLanguage cvLanguage);
}
