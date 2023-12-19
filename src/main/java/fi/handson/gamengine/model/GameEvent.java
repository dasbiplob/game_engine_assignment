package fi.handson.gamengine.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
@Entity
@Table(name = "game_events")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class GameEvent {
    private Date timestamp;
    @Id
    private String playerId;
    private String eventId;
    private String eventType;
    private Double amount;
}
