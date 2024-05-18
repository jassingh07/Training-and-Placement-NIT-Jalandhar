package in.nitj.tpo.entity;

import java.time.Instant;
import java.util.List;

import jakarta.persistence.*;
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

  @ManyToMany
  @JoinTable(
          name = "job_application",
          joinColumns = @JoinColumn(name = "job_id"),
          inverseJoinColumns = @JoinColumn(name = "roll_number")
  )
  private List<Student> applicants;
}
