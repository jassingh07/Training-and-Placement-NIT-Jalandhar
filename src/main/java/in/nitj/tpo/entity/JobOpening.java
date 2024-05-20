package in.nitj.tpo.entity;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import jakarta.persistence.*;
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
public class JobOpening {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "job_id")
  private Integer jobId;

  @NotBlank
  private String companyName;

  @NotBlank
  private String position;

  @NotNull
  private Instant closingTime;

  @DecimalMin(value = "0.0")
  @DecimalMax(value = "100.0")
  @Column(columnDefinition = "DECIMAL(5, 2) DEFAULT 0.00")
  private BigDecimal tenthPercentage;

  @DecimalMin(value = "0.0")
  @DecimalMax(value = "100.0")
  @Column(columnDefinition = "DECIMAL(5, 2) DEFAULT 0.00")
  private BigDecimal twelvePercentage;

  @DecimalMin(value = "0.0")
  @DecimalMax(value = "10.0")
  @Column(columnDefinition = "DECIMAL(3, 2) DEFAULT 0.00")
  private BigDecimal cgpa;

  @Column(columnDefinition = "INT DEFAULT 10")
  private Integer maxActiveBacklogs;

  @ManyToMany
  @JoinTable(
          name = "job_application",
          joinColumns = @JoinColumn(name = "job_id"),
          inverseJoinColumns = @JoinColumn(name = "roll_number")
  )
  private List<Student> applicants;

  @OneToMany(mappedBy = "jobOpening", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<JobDocument> jobDocuments;
}
