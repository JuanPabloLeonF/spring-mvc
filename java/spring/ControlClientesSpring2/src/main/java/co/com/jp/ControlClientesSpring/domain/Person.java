package co.com.jp.ControlClientesSpring.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "person")
public class Person implements Serializable{
    
    @Serial
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private Long idPerson;
    
    @Column(name = "name")
    @NotBlank(message = "{NotBlank.Person.name}")
    private String name;
    
    @Column(name = "last_name")
    @NotBlank(message = "{NotBlank.Person.lastName}")
    private String lastName;
    
    @Column(name = "email")
    @NotBlank(message = "{NotBlank.Person.email}")
    @Email(message = "{NotBlank.Person.email.format}")
    private String email;
    
    @Column(name = "phone")
    @NotBlank(message = "{NotBlank.Person.phone}")
    @Pattern(regexp = "\\+\\d{2} \\d{10}", message = "{NotBlank.Person.phone.format}")
    private String phone;
}
