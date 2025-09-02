package mburnayev.ESGBBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mburnayev.ESGBBackend.entity.Student;
import mburnayev.ESGBBackend.service.StudentService;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @CrossOrigin
    @GetMapping("/get/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @CrossOrigin
    @PostMapping("/post")
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

}
