package edu.velalar.library.repo;
import edu.velalar.library.model.Loan; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface LoanRepository extends JpaRepository<Loan,Long>{List<Loan> findByReturnDateIsNull(); List<Loan> findByStudentIdOrderByIssueDateDesc(Long id);}
