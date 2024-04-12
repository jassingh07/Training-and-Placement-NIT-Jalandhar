package in.nitj.tpo.dto;

import java.time.Instant;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class JobOpeningDto {
  private Integer jobId;
  private String companyName;
  private String position;
  private List<JobDocumentDto> jobDocumentDtoList;
  private Instant closingTime;
}
