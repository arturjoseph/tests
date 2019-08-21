package contact.arturneto.courses.springboot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

@Entity
@Getter@Setter
public class Student extends AbstractEntity{

    @NotEmpty
    private String name;
    @Email
    private String email;
}
