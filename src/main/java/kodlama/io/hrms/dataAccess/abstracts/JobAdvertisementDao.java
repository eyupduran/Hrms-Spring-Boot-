package kodlama.io.hrms.dataAccess.abstracts;

import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.entities.dtos.request.JobAdvertisementDetailsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
    JobAdvertisement getByEmployerId(int employerId); //EmployerId e göre sorgu

    List<JobAdvertisement> getByCity_Name(String cityName);//Şehir adına göre sorgu

    JobAdvertisement getById(int Id);//İş ilanı ıd sine göre sorgu

    // Sistemdeki tüm aktif iş ilanlarının listesi
    @Query("select new kodlama.io.hrms.entities.dtos.request.JobAdvertisementDetailsDto" +
            "(ja.id,ja.jobPosition.name,ja.openPositionCount,ja.employer.companyName,ja.lastApplyDate,ja.creationDate)" +
            " from JobAdvertisement ja where ja.isActive=true ")
    List<JobAdvertisementDetailsDto> getAllActiveJobAdvertList();

    //Sistemdeki tüm aktif iş ilanları tarihe göre listesi
    @Query("select new kodlama.io.hrms.entities.dtos.request.JobAdvertisementDetailsDto" +
            "(ja.id,ja.jobPosition.name,ja.openPositionCount,ja.employer.companyName,ja.lastApplyDate,ja.creationDate)" +
            " from JobAdvertisement ja where ja.isActive=true order by ja.creationDate asc ")
    List<JobAdvertisementDetailsDto> getAllActiveJobAdvertOrderByDateList();

//Sistemde bir firmaya ait tüm aktif iş ilanları listesi
    @Query("select new kodlama.io.hrms.entities.dtos.request.JobAdvertisementDetailsDto" +
            "(ja.id,ja.jobPosition.name,ja.openPositionCount,ja.employer.companyName,ja.lastApplyDate,ja.creationDate)" +
            " from JobAdvertisement ja where ja.isActive=true and ja.employer.id=:employerId")
    List<JobAdvertisementDetailsDto> getAllActiveJobAdvertListByEmployerId(int employerId);

}
