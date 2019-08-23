package contact.arturneto.courses.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
public class UserStudent extends AbstractEntity {

    @NotEmpty
    @Column(unique = true)
    private String username;
    @NotEmpty
    @JsonIgnore
    private String password;
    @NotEmpty
    private String name;
    @NotEmpty
    private boolean isAdmin;

}
