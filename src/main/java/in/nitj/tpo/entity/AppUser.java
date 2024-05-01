package in.nitj.tpo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import static in.nitj.tpo.Utils.AuthUtils.NITJ_EMAIL_REGEX;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class AppUser {
    @Id
    @Email(regexp = NITJ_EMAIL_REGEX, message = "Not a valid NIT JALANDHAR account")
    public String officialEmailId;
    @NotBlank(message = "Password cannot be empty")
    public String password;
}
