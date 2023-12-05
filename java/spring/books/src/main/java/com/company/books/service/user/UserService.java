package com.company.books.service.user;

import com.company.books.models.User;
import com.company.books.repository.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private IUserRepository iUserRepository;

    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.iUserRepository.findByNameUser(username);

        if (username == null) {
            log.error("error, el usuario no existe");
            throw new UsernameNotFoundException("error, el usuario no existe");
        }

        List<GrantedAuthority> grantedAuthorityList = user.getRoleList()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getNameRol()))
                .peek(authority -> log.info("Rol: " + authority.getAuthority()))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
                user.getNameUser(),
                user.getPassword(),
                user.getAuthorized(),
                true,
                true,
                true,
                grantedAuthorityList
        );
    }
}
