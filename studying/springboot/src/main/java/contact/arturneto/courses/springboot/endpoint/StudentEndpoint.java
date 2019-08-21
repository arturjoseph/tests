package contact.arturneto.courses.springboot.endpoint;

import contact.arturneto.courses.springboot.error.CustomErrorType;
import contact.arturneto.courses.springboot.error.ResourceNotFoundException;
import contact.arturneto.courses.springboot.model.Student;
import contact.arturneto.courses.springboot.repository.StudentRepository;
import contact.arturneto.courses.springboot.util.DateUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RequestMapping("/students")
@RestController
public class StudentEndpoint {

    private final StudentRepository studentDAO;

    public StudentEndpoint(StudentRepository studentDAO) {
        this.studentDAO = studentDAO;
    }

    @GetMapping
    public ResponseEntity<Page<Student>> getAll(Pageable pageable) {
        return ResponseEntity.ok().body(studentDAO.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(studentDAO.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found for ID: " + id)));
    }

    @GetMapping("findByName/{name}")
    public ResponseEntity<List<Student>> getByname(@PathVariable("name") String name) {
        return ResponseEntity.ok().body(studentDAO.findByNameIgnoreCaseContaining(name));
    }

    @PostMapping
    public ResponseEntity<Student> save(@Valid @RequestBody Student student) {
        studentDAO.save(student);
        return ResponseEntity.created(URI.create("http://localhost:8080/students/" + student.getId())).body(student);
    }

    @PutMapping
    public ResponseEntity<Student> update(@RequestBody Student student) {
        verifyStudentExists(student.getId());
        studentDAO.save(student);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Student> delete(@PathVariable("id") Long id) {
        verifyStudentExists(id);
        studentDAO.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private void verifyStudentExists(@PathVariable("id") Long id) {
        if (studentDAO.findById(id) == null) throw new ResourceNotFoundException("Student not found for ID: " + id);
    }

}
