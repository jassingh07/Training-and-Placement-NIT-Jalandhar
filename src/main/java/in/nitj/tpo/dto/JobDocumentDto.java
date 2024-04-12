package in.nitj.tpo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class JobDocumentDto {
  private String link;
  private String fileName;
}
