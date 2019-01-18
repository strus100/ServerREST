package matuszewski.pracownia.repository;

import matuszewski.pracownia.model.Audiobooks;
import matuszewski.pracownia.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudiobookRepository extends JpaRepository<Audiobooks,Long> {

}
