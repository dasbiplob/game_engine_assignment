package fi.handson.gamengine.repository;

import fi.handson.gamengine.model.Customer;
import fi.handson.gamengine.model.GameAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Repository interface for managing Customer entities.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    /**
     * Retrieves the account balance of a customer by their ID.
     *
     * @param id The ID of the customer.
     * @return The account balance as a Double.
     */
    @Query(value = "select c.accountBalanace from customers c where c.id = :id")
    Double findAccountBalance(@Param("id") String id);
}
