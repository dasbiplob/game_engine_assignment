package fi.handson.gamengine.repository;


import fi.handson.gamengine.model.GameAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing GameAccount entities.
 */
@Repository
public interface GameAccountRepository extends JpaRepository<GameAccount, Long> {

    /**
     * Retrieves the customer ID associated with a player ID.
     *
     * @param id The player ID.
     * @return The associated customer ID as a String.
     */
    @Query(value = "select c.customerId from game_accounts c where c.playerId = :id")
    String findCustomerId(@Param("playerId") String id);
}
