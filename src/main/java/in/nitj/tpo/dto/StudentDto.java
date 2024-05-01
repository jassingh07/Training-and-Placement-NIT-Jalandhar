package in.nitj.tpo.dto;

import java.math.BigDecimal;
import java.util.List;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class StudentDto {
  @Digits(integer = 8, fraction = 0, message = "Roll number must be an integer with exactly 8 digits")
  private Integer rollNumber;
  @NotBlank
  private String firstName;
  private String lastName;
  @NotBlank
  private String phoneNumberWithoutCountryCode;
  @NotBlank
  private String branch;
  @Email(message = "not a valid personal email")
  private String personalEmailId;
  @Email(regexp = "^[a-zA-Z0-9_.-]+@nitj\\.ac\\.in$\n", message = "Not a valid NIT JALANDHAR account")
  private String officialEmailId;

  private boolean tpoRepresentative;
  private BigDecimal tenthPercentage;
  private BigDecimal twelvePercentage;
  private BigDecimal cgpa;
  private boolean activeBacklogs;
  private List<DocumentDto> resumeDtoList;
}
