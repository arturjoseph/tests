package contact.arturneto.courses.springboot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

@Entity
@Getter@Setter@NoArgsConstructor
public class Student extends AbstractEntity{
    @NotEmpty(message = "O campo name do estudante é obrigatório!")
    private String name;
    @NotEmpty(message = "O campo email do estudante é obrigatório!")
    @Email
    private String email;
}
