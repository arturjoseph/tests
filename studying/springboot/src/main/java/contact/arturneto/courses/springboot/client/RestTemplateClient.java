package contact.arturneto.courses.springboot.client;

import contact.arturneto.courses.springboot.model.Student;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateClient {
    public static void main(String[] args) {
        RestTemplate rest = new RestTemplateBuilder()
                .rootUri("http://localhost:8080/v1/protected/students")
                .basicAuthorization("user", "User")
                .build();
        Student student = rest.getForObject("/{id}", Student.class, 1);
        ResponseEntity<Student> entity = rest.getForEntity("/{id}", Student.class, 1);
        System.out.println(student);
        System.out.println(entity);
    }
}
