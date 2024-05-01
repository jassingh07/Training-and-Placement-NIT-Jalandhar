package in.nitj.tpo.service;

import in.nitj.tpo.dto.SignupRequest;
import in.nitj.tpo.entity.AppUser;
import in.nitj.tpo.exception.DuplicateException;
import in.nitj.tpo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;


    @Transactional
    public void signup(SignupRequest request) {
        String email = request.getOfficialEmailId();
        Optional<AppUser> existingUser = repository.findById(email);
        if (existingUser.isPresent()) {
            throw new DuplicateException(String.format("AppUser with the email address '%s' already exists.", email));
        }
        String hashedPassword = passwordEncoder.encode(request.getPassword());
        AppUser appUser = AppUser.builder()
                .officialEmailId(email)
                .password(hashedPassword)
                .build();
        repository.save(appUser);
    }
}
