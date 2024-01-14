package fi.handson.gamengine.repository;


import fi.handson.gamengine.model.GameEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameEventRepository extends CrudRepository<GameEvent, Long> {

}
