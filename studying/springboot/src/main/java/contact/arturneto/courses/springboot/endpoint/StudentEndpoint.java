package contact.arturneto.courses.springboot.endpoint;

import contact.arturneto.courses.springboot.error.CustomErrorType;
import contact.arturneto.courses.springboot.model.Student;
import contact.arturneto.courses.springboot.util.DateUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/students")
@RestController
public class StudentEndpoint {

    private final DateUtil dateUtil;

    public StudentEndpoint(DateUtil dateUtil) {
        this.dateUtil = dateUtil;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok().body(Student.studentList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable("id") int id) {
        Student student = Student.studentList.stream()
                .filter(s -> s.getId() == id).findFirst().orElse(new Student());
        if (student.getId() <= 0)
            return new ResponseEntity(new CustomErrorType("Student not found!"), HttpStatus.NOT_FOUND);
        return ResponseEntity.ok().body(student);
    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student) {
        Student.studentList.add(student);
        return ResponseEntity.created(URI.create("http://localhost:8080/students/" + student.getId())).body(student);
    }

    @PutMapping
    public ResponseEntity<Student> update(@RequestBody Student student) {
        Student.studentList.add(student);
        return ResponseEntity.accepted().body(student);
    }

    @DeleteMapping
    public ResponseEntity<Student> delete(@RequestBody Student student) {
        Student.studentList.remove(student);
        return ResponseEntity.noContent().build();
    }

}
