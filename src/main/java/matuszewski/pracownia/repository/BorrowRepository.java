package matuszewski.pracownia.repository;

import matuszewski.pracownia.model.Borrows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRepository extends JpaRepository<Borrows,Long> {

}
