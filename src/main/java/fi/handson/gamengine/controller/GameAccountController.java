package fi.handson.gamengine.controller;

import fi.handson.gamengine.model.GameEvent;
import fi.handson.gamengine.service.GameAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * Controller class responsible for handling HTTP requests related to game accounts.
 * Endpoints in this controller are under the "/api/accounts" path.
 */
@RestController
@RequestMapping("/api/accounts")
public class GameAccountController {
    /**
     * Service responsible for processing game account-related operations.
     */
    private final GameAccountService gameAccountService;

    /**
     * Constructor for the GameAccountController class.
     *
     * @param gameAccountService An instance of GameAccountService for handling account-related operations.
     */
    @Autowired
    public GameAccountController(GameAccountService gameAccountService) {
        this.gameAccountService = gameAccountService;
    }

    /**
     * Handles HTTP POST requests for triggering game events.
     * The endpoint is "/api/accounts/event".
     *
     * @param event The game event data received in the request body.
     * @return ResponseEntity with the remaining balance after processing the event.
     */

    @PostMapping ("/event")
    public ResponseEntity<Double> triggerEvent(@RequestBody GameEvent event) {
        try {
            // Process the game event and get the remaining balance.
            Double remainingBalance = gameAccountService.triggerEvent(event);
            // Respond with the remaining balance in the ResponseEntity.
            return ResponseEntity.ok(remainingBalance);
        } catch (RuntimeException ex) {
            // Handle RuntimeException (e.g., invalid event type)
            return ResponseEntity.badRequest().body(null); // You can customize the response as needed
        } catch (Exception ex) {
            // Handle other exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // You can customize the response as needed
        }
    }
}
