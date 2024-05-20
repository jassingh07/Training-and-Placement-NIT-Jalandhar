package in.nitj.tpo.entity;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static in.nitj.tpo.Utils.AuthUtils.NITJ_EMAIL_REGEX;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Student{
  @Id
  private Integer rollNumber;
  @NotBlank
  private String firstName;
  private String lastName;
  @NotBlank
  private String phoneNumberWithoutCountryCode;
  @NotBlank
  private String branch;
  @NotBlank
  private String personalEmailId;
  @Email(regexp = NITJ_EMAIL_REGEX, message = "Not a valid NIT JALANDHAR account")
  private String officialEmailId;
  private boolean tpoRepresentative;//allow only tpo to write on this

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

  private Integer activeBacklogs;

  @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  private List<Resume> resumeDtoList;

  @ManyToMany(mappedBy = "applicants")
  @JsonBackReference
  private List<JobOpening> appliedJobs;
}
