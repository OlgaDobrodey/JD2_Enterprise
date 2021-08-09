package by.it_academy.jd2.core.service;


import by.it_academy.jd2.core.model.people.User;
import by.it_academy.jd2.core.service.api.IAuthService;
import by.it_academy.jd2.storage.api.people.IUserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;

public class AuthService implements IAuthService {

    private final IUserRepository userRepository;

    public AuthService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return org.springframework.security.core.userdetails.User.withUserDetails(new UserWrapper(user)).build();
    }

    @Override
    @Transactional
    public void saveAuthorizedClient(OAuth2AuthorizedClient authorizedClient, Authentication principal) {
        User user = new User();
        user.setGithubId(principal.getName());
//        user.setRole(Role.USER);
        OAuth2User oAuth2User = (OAuth2User) principal.getPrincipal();
        user.setUsername(oAuth2User.getAttribute("username"));

        try{
            userRepository.save(user);
        } catch (DataIntegrityViolationException e){
            //такой пользователь уже есть
        }
    }

    private class UserWrapper implements UserDetails{
        private final User user;

        public UserWrapper(User user) {
            this.user = user;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
        }

        @Override
        public String getPassword() {
            return this.user.getPassword();
        }

        @Override
        public String getUsername() {
            return this.user.getUsername();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
