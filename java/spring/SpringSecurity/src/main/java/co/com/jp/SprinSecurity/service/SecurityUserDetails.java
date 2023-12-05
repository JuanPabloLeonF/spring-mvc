package co.com.jp.SprinSecurity.service;

import co.com.jp.SprinSecurity.repository.IUserRepository;
import co.com.jp.SprinSecurity.security.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetails implements UserDetailsService{
    
    private final IUserRepository iUserRepository;

    public SecurityUserDetails(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var optionalUser = this.iUserRepository.findByName(username);
        
        if(optionalUser.isPresent()){
            return new SecurityUser(optionalUser.get());
        }
        
        throw new UsernameNotFoundException("User no found" + username);
    }
}
