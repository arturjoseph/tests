package contact.arturneto.courses.springboot.service;

import contact.arturneto.courses.springboot.model.UserStudent;
import contact.arturneto.courses.springboot.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomUserDetails implements UserDetailsService {

    private final UserRepository userDAO;

    public CustomUserDetails(UserRepository userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserStudent user = userDAO.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));
        List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
        List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
        return new User(user.getUsername(),user.getPassword(), user.isAdmin() ? authorityListAdmin : authorityListUser);

    }
}
