package in.nitj.tpo.dto;

import java.math.BigDecimal;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class StudentDto {
  private Integer rollNumber;
  private String firstName;
  private String lastName;
  private String phoneNumberWithoutCountryCode;
  private String branch;
  private String personalEmailId;
  private String officialEmailId;
  private BigDecimal tenthPercentage;
  private BigDecimal twelvePercentage;
  private BigDecimal cgpa;
  private boolean activeBacklogs;
  private List<ResumeDto> resumeDtoList;
}
