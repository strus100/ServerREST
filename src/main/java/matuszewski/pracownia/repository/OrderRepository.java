package matuszewski.pracownia.repository;

import matuszewski.pracownia.model.Books;
import matuszewski.pracownia.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Long> {

}
