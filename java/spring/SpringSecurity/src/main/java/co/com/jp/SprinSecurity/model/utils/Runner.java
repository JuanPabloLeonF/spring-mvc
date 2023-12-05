package co.com.jp.SprinSecurity.model.utils;

import co.com.jp.SprinSecurity.model.Authority;
import co.com.jp.SprinSecurity.model.User;
import co.com.jp.SprinSecurity.repository.IAuthorityRepository;
import co.com.jp.SprinSecurity.repository.IUserRepository;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner{
 
    private final IUserRepository iUserRepository;
    private final IAuthorityRepository iAuthorityRepository;

    public Runner(IUserRepository iUserRepository, IAuthorityRepository iAuthorityRepository) {
        this.iUserRepository = iUserRepository;
        this.iAuthorityRepository = iAuthorityRepository;
    }
    
    @Override
    public void run(String... args)throws Exception {
        
        if(this.iAuthorityRepository.count() == 0){
            this.iAuthorityRepository.saveAll(List.of(
                    new Authority(AuthorityName.ADMIN),
                    new Authority(AuthorityName.READ),
                    new Authority(AuthorityName.WRITE)
            ));
        }
        
        if(this.iUserRepository.count() == 0){
            
            var passwordEncoderFactories = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            
            this.iUserRepository.saveAll(List.of(
                    new User("usuario1", passwordEncoderFactories.encode("usuario1123"), List.of(this.iAuthorityRepository.findByName(AuthorityName.ADMIN).get())),
                    new User("usuario2", passwordEncoderFactories.encode("1234"), List.of(this.iAuthorityRepository.findByName(AuthorityName.READ).get())),
                    new User("usuario3", passwordEncoderFactories.encode("098"), List.of(this.iAuthorityRepository.findByName(AuthorityName.WRITE).get()))
            ));
        }
    }
}
