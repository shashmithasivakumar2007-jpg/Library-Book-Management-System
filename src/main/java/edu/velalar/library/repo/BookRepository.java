package edu.velalar.library.repo;
import edu.velalar.library.model.Book; import org.springframework.data.jpa.repository.JpaRepository;
public interface BookRepository extends JpaRepository<Book,Long>{}
