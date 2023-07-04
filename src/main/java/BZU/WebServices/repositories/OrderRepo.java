package BZU.WebServices.repositories;


import BZU.WebServices.models.Ordere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Ordere,Integer> {
}
