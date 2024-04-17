package in.nitj.tpo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class DocumentDto {
    private String link;
    private String fileName;
}
