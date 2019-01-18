package matuszewski.pracownia.repository;

import matuszewski.pracownia.model.Books;
import matuszewski.pracownia.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

}
