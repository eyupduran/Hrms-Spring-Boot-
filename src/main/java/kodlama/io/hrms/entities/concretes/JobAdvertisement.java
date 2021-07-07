package kodlama.io.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="JobAdvertisements")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name ="description")
    private String description;
    @Column(name ="minSalary")
    private int minSalary;
    @Column(name ="maxSalary")
    private int maxSalary;
    @Column(name ="openPositionCount")
    private int openPositionCount;
    @Column(name ="lastApplyDate")
    private Date lastApplyDate;
    @Column(name ="creationDate")
    private Date creationDate;
    @NotNull
    @Column(name="isActive")
    private boolean isActive;

    @ManyToOne()
    @JoinColumn(name="jobPositionId")
    private JobPosition jobPosition;

    @ManyToOne()
    @JoinColumn(name="employerId")
    private Employer employer;

    @ManyToOne()
    @JoinColumn(name ="cityId")
    private City city;



}
