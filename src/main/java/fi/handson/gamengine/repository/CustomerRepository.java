package fi.handson.gamengine.repository;

import fi.handson.gamengine.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;




@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Query(value = "select c.accountBalance from Customer c where c.id = :id")
    Double findAccountBalance(@Param("id") String id);
}
