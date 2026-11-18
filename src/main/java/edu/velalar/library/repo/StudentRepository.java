package edu.velalar.library.repo;
import edu.velalar.library.model.Student; import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentRepository extends JpaRepository<Student,Long>{}
