package contact.arturneto.courses.springboot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
public class Student extends AbstractEntity {
    @NotEmpty(message = "O campo name do estudante é obrigatório!")
    private String name;
    @NotEmpty(message = "O campo email do estudante é obrigatório!")
    @Email
    private String email;
}
