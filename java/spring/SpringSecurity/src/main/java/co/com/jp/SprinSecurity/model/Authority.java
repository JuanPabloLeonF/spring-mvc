package co.com.jp.SprinSecurity.model;

import co.com.jp.SprinSecurity.model.utils.AuthorityName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "authority")
public class Authority implements Serializable{
    
    @Serial
    private Serializable serializable = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_authority")
    private Long idAuthority;
    @Column(name = "name")
    private AuthorityName name;
    @Column(name = "password")
    private String password;

    public Authority(AuthorityName authorityName) {
        this.name = authorityName;
    }
}
