package in.nitj.tpo.service;

import in.nitj.tpo.entity.AppUser;
import in.nitj.tpo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) {

        AppUser appUser = repository.findById(email).orElseThrow(() ->
                new UsernameNotFoundException(String.format("AppUser does not exist, email: %s", email)));

        return org.springframework.security.core.userdetails.User.builder()
                .username(appUser.getOfficialEmailId())
                .password(appUser.getPassword())
                .build();
    }
}