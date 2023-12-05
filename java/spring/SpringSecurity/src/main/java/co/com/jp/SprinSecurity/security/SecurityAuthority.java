package co.com.jp.SprinSecurity.security;

import co.com.jp.SprinSecurity.model.Authority;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority{

    private final Authority authority;
    
    @Override
    public String getAuthority() {
        return authority.getName().toString();
    }
}
