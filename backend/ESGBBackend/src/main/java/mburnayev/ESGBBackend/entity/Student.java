package mburnayev.ESGBBackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sID;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "pwdhash", nullable = false)
    private String pwdhash;

    @Column(name = "grade0", nullable = true)
    private String grade0;

    @Column(name = "grade1", nullable = true)
    private String grade1;

    @Column(name = "grade2", nullable = true)
    private String grade2;

    @Column(name = "grade3", nullable = true)
    private String grade3;

    @Column(name = "grade4", nullable = true)
    private String grade4;

    @Column(name = "grade5", nullable = true)
    private String grade5;

    @Column(name = "grade6", nullable = true)
    private String grade6;

    @Column(name = "grade7", nullable = true)
    private String grade7;

    @Column(name = "grade8", nullable = true)
    private String grade8;

    @Column(name = "grade9", nullable = true)
    private String grade9;

    // Getters
    public int getsID() {
        return sID;
    }

    public String getUsername() {
        return username;
    }

    public String getPwdhash() {
        return pwdhash;
    }

    public String getGrade0() {
        return grade0;
    }

    public String getGrade1() {
        return grade1;
    }

    public String getGrade2() {
        return grade2;
    }

    public String getGrade3() {
        return grade3;
    }

    public String getGrade4() {
        return grade4;
    }

    public String getGrade5() {
        return grade5;
    }

    public String getGrade6() {
        return grade6;
    }

    public String getGrade7() {
        return grade7;
    }

    public String getGrade8() {
        return grade8;
    }

    public String getGrade9() {
        return grade9;
    }

    // Setters
    public void setsID(int id) {
        sID = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPwdhash(String hash) {
        pwdhash = hash;
    }

    public void setGrade0(String grade) {
        grade0 = grade;
    }

    public void setGrade1(String grade) {
        grade1 = grade;
    }

    public void setGrade2(String grade) {
        grade2 = grade;
    }

    public void setGrade3(String grade) {
        grade3 = grade;
    }

    public void setGrade4(String grade) {
        grade4 = grade;
    }

    public void setGrade5(String grade) {
        grade5 = grade;
    }

    public void setGrade6(String grade) {
        grade6 = grade;
    }

    public void setGrade7(String grade) {
        grade7 = grade;
    }

    public void setGrade8(String grade) {
        grade8 = grade;
    }

    public void setGrade9(String grade) {
        grade9 = grade;
    }

    // @Override
    // public String toString() {
    //     return "Student {" + "id = ";
    // }
}
