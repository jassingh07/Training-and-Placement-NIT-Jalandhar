package in.nitj.tpo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import static in.nitj.tpo.Utils.AuthUtils.NITJ_EMAIL_REGEX;

@Builder
@Getter
@Setter
public class LoginRequest {
    @Email(regexp = NITJ_EMAIL_REGEX, message = "Not a valid NIT JALANDHAR account")
    private String email;
    @NotBlank
    private String password;
}
