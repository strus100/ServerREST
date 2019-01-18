package matuszewski.pracownia.repository;

import matuszewski.pracownia.model.Books;
import matuszewski.pracownia.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Books,Long> {

}
