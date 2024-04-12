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
public class Resume {
  @Id
  private Integer rollNumber;

  @MapsId
  @ManyToOne
  @JoinColumn(name="roll_number", nullable = false)
  private Student student;

  private String link;
  private String file_name;
}
