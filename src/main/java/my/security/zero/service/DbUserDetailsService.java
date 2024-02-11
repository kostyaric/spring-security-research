package my.security.zero.service;

import my.security.zero.dao.security.AppUser;
import my.security.zero.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DbUserDetailsService implements UserDetailsService {

    private final UserRepository userRepo;

    public DbUserDetailsService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser appUser = userRepo.findByLogin(username);
        return User.builder()
                .username(username)
                .password(appUser.getPassword())
                .roles("ADMIN")
                .authorities("WRITE")
                .build();

    }
}
