package co.com.jp.SprinSecurity.repository;

import co.com.jp.SprinSecurity.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long>{
    
    Optional<User> findByName(String userName);
}
