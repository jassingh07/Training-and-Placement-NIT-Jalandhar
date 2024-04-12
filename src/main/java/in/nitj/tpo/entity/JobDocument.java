package in.nitj.tpo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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
public class JobDocument{
  @Id
  private Integer jobId;

  @MapsId
  @ManyToOne
  @JoinColumn(name = "job_id", nullable = false)
  private JobOpening jobOpening;
  private String link;
  private String fileName;
}
