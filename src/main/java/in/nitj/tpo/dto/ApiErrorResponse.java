package in.nitj.tpo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ApiErrorResponse {
    private int status;
    private String message;
}
