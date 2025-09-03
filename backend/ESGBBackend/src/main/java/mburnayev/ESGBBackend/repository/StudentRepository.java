package mburnayev.ESGBBackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mburnayev.ESGBBackend.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findByUsername(String username);
}
