package fi.handson.gamengine.repository;


import fi.handson.gamengine.model.GameEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing GameEvent entities.
 */
@Repository
public interface GameEventRepository extends JpaRepository<GameEvent, Long> {


}
