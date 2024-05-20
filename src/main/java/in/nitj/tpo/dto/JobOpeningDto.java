package in.nitj.tpo.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class JobOpeningDto {
  private String companyName;
  private String position;
  private List<DocumentDto> jobDocumentDtoList;
  private Instant closingTime;
  private BigDecimal tenthPercentage;
  private BigDecimal twelvePercentage;
  private BigDecimal cgpa;
  private Integer maxActiveBacklogs;
}
