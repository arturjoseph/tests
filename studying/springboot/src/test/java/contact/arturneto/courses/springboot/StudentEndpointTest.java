package contact.arturneto.courses.springboot;

import contact.arturneto.courses.springboot.model.Student;
import contact.arturneto.courses.springboot.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class StudentEndpointTest {

    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort
    private int port;
    @MockBean
    private StudentRepository studentDAO;
    @Autowired
    private MockMvc mockMvc;

    @TestConfiguration
    static class Config{
        @Bean
        public RestTemplateBuilder restTemplateBuilder(){
            return new RestTemplateBuilder().basicAuthorization("admin","Admin");
        }
    }

    @Test
    public void listStudentWhenUserNameAndPasswordAreIncorrectShouldReturnStatusCode401(){
        restTemplate = restTemplate.withBasicAuth("1","1");
        ResponseEntity<String> response = restTemplate.getForEntity("/v1/protected/students/", String.class);
        assertThat(response.getStatusCodeValue()).isEqualTo(401);
    }
    @Test
    public void getStudentByIdStudentWhenUserNameAndPasswordAreIncorrectShouldReturnStatusCode401(){
        restTemplate = restTemplate.withBasicAuth("1","1");
        ResponseEntity<String> response = restTemplate.getForEntity("/v1/protected/students/1", String.class);
        assertThat(response.getStatusCodeValue()).isEqualTo(401);
    }
    @Test
    public void listStudentWhenUserNameAndPasswordAreCorrectShouldReturnStatusCode200(){
        List<Student> students = Arrays.asList(new Student(1L, "Artur", "artur@artur.com"), new Student(2L, "jose", "jose@artur.com"));
        BDDMockito.when(studentDAO.findAll()).thenReturn(students);
        ResponseEntity<String> response = restTemplate.getForEntity("/v1/protected/students/", String.class);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
    }

}

