package contact.arturneto.courses.springboot;

import contact.arturneto.courses.springboot.model.Student;
import contact.arturneto.courses.springboot.repository.StudentRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository dao;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void createShouldPersisData(){
        Student student = new Student("Neto", "neto@neto.com");
        this.dao.save(student);

        assertThat(student.getId()).isNotNull();
        assertThat(student.getName()).isEqualTo("Neto");
        assertThat(student.getEmail()).isEqualTo("neto@neto.com");
    }
    @Test
    public void deleteShouldRemoveData(){
        Student student = new Student("Neto", "neto@neto.com");
        this.dao.save(student);
        this.dao.delete(student);

        assertThat(this.dao.findById(student.getId())).isEmpty();
    }
    @Test
    public void updateShouldChangeData(){
        Student neto = new Student("Neto", "neto@neto.com");
        this.dao.save(neto);
        neto.setEmail("neto@jose.com");
        this.dao.save(neto);

        assertThat(neto.getName()).isEqualTo("Neto");
        assertThat(neto.getEmail()).isEqualTo("neto@jose.com");
    }
    @Test
    public void findByNameIgnoreCaseContaining(){
        Student neto = new Student("Neto", "neto@neto.com");
        Student netoM = new Student("neto", "neto@neto.com");
        this.dao.save(neto);
        this.dao.save(netoM);
        List<Student> students = this.dao.findByNameIgnoreCaseContaining("neto");

        assertThat(students.size()).isEqualTo(2);
    }

}
