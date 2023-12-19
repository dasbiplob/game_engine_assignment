package fi.handson.gamengine.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table (name = "game_accounts")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GameAccount {
    @Id
    private String customerId;
    private String playerId;
}
