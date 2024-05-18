package in.nitj.tpo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class JobApplyDto {
    private Integer rollNumber;
    private Integer jobId;
}
