package kodlama.io.hrms.entities.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDetailsDto {
    private int id;
    private String jobPositionName;
    private int openPositionCount;
    private String companyName;
    private Date lastApply;
    private Date creationDate;
}
