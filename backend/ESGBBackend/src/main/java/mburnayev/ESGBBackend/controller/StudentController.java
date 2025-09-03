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
        Student student = studentService.getStudentById(id);
        System.out.println(student.getsID() + student.getUsername());
        return student;
    }

    @CrossOrigin
    @GetMapping("/check/{username}+{password}")
    public Student getStudentByLoginCredentials(@PathVariable String username, @PathVariable String password) {
        return studentService.getStudentByLoginCredentials(username, password);
    }

    @CrossOrigin
    @PostMapping("/post")
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

}
