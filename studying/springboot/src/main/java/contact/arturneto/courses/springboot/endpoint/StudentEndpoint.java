package contact.arturneto.courses.springboot.endpoint;

import contact.arturneto.courses.springboot.error.CustomErrorType;
import contact.arturneto.courses.springboot.model.Student;
import contact.arturneto.courses.springboot.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

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
    public ResponseEntity<Student> getById(@PathVariable("id") Integer id) {
        Student student = new Student();
        student.setId(id);
        Integer index = Student.studentList.indexOf(student);
        if (index == -1) {
            return new ResponseEntity(new CustomErrorType("Student not found!"), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body( Student.studentList.get(index));
    }

}
