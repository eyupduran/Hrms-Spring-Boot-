package kodlama.io.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "userId")

@Table(name = "Employers")
public class Employer extends User {

    @Column(name = "companyName")
    private String companyName;
    @Column(name = "websiteLink")
    private String webSiteLink;
    @Column(name = "phone")
    private String phone;
    @Column(name = "confirmationId")
    private String confirmationId;
}
