package in.nitj.tpo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Builder
@Getter
@Setter
public class AnnouncementDto {
    String content;
    Instant creationTime;
    List<DocumentDto> relatedFiles;
}
