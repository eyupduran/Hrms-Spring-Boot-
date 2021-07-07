package kodlama.io.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "userId")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","JobAdvertisements"})

@Table(name = "Employers")
public class Employer extends User {

    @Column(name = "companyName")
    private String companyName;
    @Column(name = "websiteLink")
    private String webSiteLink;
    @Column(name = "phone")
    private String phone;
 //   @Column(name = "confirmationId")
   // private String confirmationId;
    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> jobAdvertisements;
}
