package kodlama.io.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "userId")
@Table(name ="jobSeekers")
public class JobSeeker extends User {

    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "birthDate")
    private Date birthDate;
    @Column(name = "NationalIdentityNumber")
    private String nationalIdentityNumber;
    //@Column(name = "ConfirmationId")
    //private int confirmationİd;
    @ManyToOne()
    @JoinColumn(name="jobAdvertisementId")
    private JobAdvertisement jobAdvertisement;

    @JsonIgnore
    @OneToMany(mappedBy = "jobSeeker")
    private List<Cv> cvs;
}
