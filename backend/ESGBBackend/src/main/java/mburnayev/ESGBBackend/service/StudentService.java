package mburnayev.ESGBBackend.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mburnayev.ESGBBackend.entity.Student;
import mburnayev.ESGBBackend.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private static final String[] GRADES = { "A", "B", "C", "D", "F" };

    // GET, Read
    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    // POST, Create
    public Student saveStudent(Student student) {
        Random r = new Random();
        int numGrades = r.nextInt(10) + 1;
        for (int i = 0; i < numGrades; i++) {
            String grade = GRADES[r.nextInt(GRADES.length)];
            setGradeByIndex(student, i, grade);
        }

        return studentRepository.save(student);
    }

    private void setGradeByIndex(Student student, int index, String grade) {
        switch (index) {
            case 0 -> student.setGrade0(grade);
            case 1 -> student.setGrade1(grade);
            case 2 -> student.setGrade2(grade);
            case 3 -> student.setGrade3(grade);
            case 4 -> student.setGrade4(grade);
            case 5 -> student.setGrade5(grade);
            case 6 -> student.setGrade6(grade);
            case 7 -> student.setGrade7(grade);
            case 8 -> student.setGrade8(grade);
            case 9 -> student.setGrade9(grade);
        }
    }
}
