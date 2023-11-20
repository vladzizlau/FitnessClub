package by.pvt.core.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CompositeTypeRegistrations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClientDetailServise implements UserDetailsService {
    private ClientService clientService;

    @Autowired
    public ClientDetailServise(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = clientService.getClientByUserName(username);
        return userDetails;
    }
}
