package pl.jakubtuminski.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

public class UserDetailsServiceImp implements UserDetailsService {

    private UserService userService;

    @Autowired
    public void setUserRepository(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUserName(username);
        UserBuilder builder = null;
        if (user != null) {
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            user.getRoles().forEach(r ->
                    grantedAuthorities.add(new SimpleGrantedAuthority(r.getName())));
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
//            builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
            builder.password(user.getPassword());
            builder.authorities(grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }
}


