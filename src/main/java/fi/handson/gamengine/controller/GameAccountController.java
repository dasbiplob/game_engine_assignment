package fi.handson.gamengine.controller;

import fi.handson.gamengine.model.GameEvent;
import fi.handson.gamengine.service.GameAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class responsible for handling HTTP requests related to game accounts.
 * Endpoints in this class are under the "/api/accounts" base path.
 */
@RestController
@RequestMapping("/api/accounts")
public class GameAccountController {

    private final GameAccountService gameAccountService;

    /**
     * Constructor-based dependency injection for GameAccountService.
     *
     * @param gameAccountService The service responsible for game account operations.
     */
    @Autowired
    public GameAccountController(GameAccountService gameAccountService) {
        this.gameAccountService = gameAccountService;
    }

    /**
     * Handles HTTP POST requests to "/api/accounts/event" for triggering a game event.
     *
     * @param event The game event data sent in the request body.
     * @return ResponseEntity containing the remaining balance after processing the event.
     */

    @PostMapping ("/event")
    public ResponseEntity<Double> triggerEvent(@RequestBody GameEvent event) {
        // Trigger the event and get the remaining balance from the GameAccountService.
        Double remainingBalance = gameAccountService.triggerEvent(event);
        // Respond with the remaining balance in the HTTP response body.
        return ResponseEntity.ok(remainingBalance);
    }

}
