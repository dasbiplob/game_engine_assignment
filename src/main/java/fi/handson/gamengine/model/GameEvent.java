package fi.handson.gamengine.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "game_events")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class GameEvent implements Serializable {
    @Column(name="time_stamp")
    private Date time_stamp;
    @Id
    @Column(name="player_id")
    private String player_id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="event_id")
    private String event_id;
    @Column(name="event_type")
    private String event_type;
    @Column(name="amount")
    private Double amount;

    public GameEvent(String player_id, String event_type, Double amount, String event_id) {
        this.player_id = player_id;
        this.event_type = event_type;
        this.amount = amount;
        this.event_id = event_id;
        this.time_stamp = new Date();
    }
}
