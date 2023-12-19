package fi.handson.gamengine.repository;


import fi.handson.gamengine.model.GameAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface GameAccountRepository extends CrudRepository<GameAccount, Long> {

    @Query(value = "select c.customer_id from GameAccount c where c.player_id = :player_id")
    String findCustomerId(@Param("player_id") String id);
}
