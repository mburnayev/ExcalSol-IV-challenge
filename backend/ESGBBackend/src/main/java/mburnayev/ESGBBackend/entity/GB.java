package mburnayev.ESGBBackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student")
public class GB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sID;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String pwdhash;

    public int getsID() {
        return sID;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPwdhash() {
        return pwdhash;
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
}
