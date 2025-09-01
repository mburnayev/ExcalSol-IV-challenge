package mburnayev.ESGBBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mburnayev.ESGBBackend.entity.GB;

@Repository
public interface GBRepository extends JpaRepository<GB, Integer>{
    
}
