package co.com.jp.SprinSecurity.repository;

import co.com.jp.SprinSecurity.model.Authority;
import co.com.jp.SprinSecurity.model.utils.AuthorityName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorityRepository extends JpaRepository<Authority, Long>{
    
    Optional<Authority> findByName(AuthorityName authorityName);
}
