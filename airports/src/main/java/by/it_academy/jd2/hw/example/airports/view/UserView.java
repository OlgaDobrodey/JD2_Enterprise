package by.it_academy.jd2.hw.example.airports.view;

import by.it_academy.jd2.hw.example.airports.storage.api.IUserRepository;
import by.it_academy.jd2.hw.example.airports.view.api.IUserView;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserView implements IUserView {
    private IUserRepository repository;

    public UserView(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
