package in.nitj.tpo.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Student {
  @Id
private Integer rollNumber;
  @NotBlank
  private String firstName;
  @NotBlank
  private String lastName;
  @NotBlank
  private String phoneNumberWithoutCountryCode;
  @NotBlank
  private String branch;
  @NotBlank
  private String personalEmailId;
  @NotBlank
  private String officialEmailId;

  @DecimalMin(value = "0.0")
  @DecimalMax(value = "100.0")
  @NotNull
  private BigDecimal tenthPercentage = BigDecimal.ZERO.setScale(2);

  @DecimalMin(value = "0.0")
  @DecimalMax(value = "100.0")
  @NotNull
  private BigDecimal twelvePercentage = BigDecimal.ZERO.setScale(2);

  @DecimalMin(value = "0.0")
  @DecimalMax(value = "10.0")
  @NotNull
  private BigDecimal cgpa = BigDecimal.ZERO.setScale(2);

  private boolean activeBacklogs;
}
