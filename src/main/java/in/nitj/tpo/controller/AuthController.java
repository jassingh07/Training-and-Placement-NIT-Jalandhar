package in.nitj.tpo.controller;

import in.nitj.tpo.dto.LoginRequest;
import in.nitj.tpo.dto.LoginResponse;
import in.nitj.tpo.dto.SignupRequest;
import in.nitj.tpo.enums.Role;
import in.nitj.tpo.service.JwtService;
import in.nitj.tpo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static in.nitj.tpo.Utils.RouteConstants.LOGIN;
import static in.nitj.tpo.Utils.RouteConstants.SIGNUP;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    @PostMapping(SIGNUP)
    public ResponseEntity<Void> signup(@Valid @RequestBody SignupRequest requestDto) {
        userService.signup(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PostMapping(LOGIN)
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        String officialEmailId = request.getEmail();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(officialEmailId, request.getPassword()));
        int count = officialEmailId.substring(0, officialEmailId.indexOf('@')).split("\\.").length;
        Map<String, Object> extraClaims = new HashMap<>();
        String roles = "";
        if(count == 1){
            roles = Role.TPO.name();
        } else if (count == 3){
            roles = Role.STUDENT.name();
        }
        extraClaims.put("Roles", roles);
        extraClaims.put("sub", officialEmailId);

        String token = jwtService.generateToken(extraClaims, officialEmailId);
        return ResponseEntity.ok(LoginResponse.builder()
                .email(request.getEmail())
                .jwtToken(token)
                .build());
    }

}
