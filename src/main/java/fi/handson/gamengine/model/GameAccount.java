package fi.handson.gamengine.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table (name = "game_accounts")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GameAccount implements Serializable {
    @Id
    @Column(name="customer_id")
    private String customer_id;

    @Column(name="player_id")
    private String player_id;


}
