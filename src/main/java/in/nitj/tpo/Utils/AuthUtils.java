package in.nitj.tpo.Utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthUtils {
    public static final String AUTH_TOKEN_KEY = "Auth-Token";
    public static final String NITJ_EMAIL_REGEX = "^[a-zA-Z0-9_.-]+@nitj\\.ac\\.in$";

    public static String getOfficialEmailIdFromContext(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
