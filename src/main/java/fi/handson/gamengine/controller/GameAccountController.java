package fi.handson.gamengine.controller;

import fi.handson.gamengine.model.GameEvent;
import fi.handson.gamengine.service.GameAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/accounts")
public class GameAccountController {

    private final GameAccountService gameAccountService;
    @Autowired
    public GameAccountController(GameAccountService gameAccountService) {
        this.gameAccountService = gameAccountService;
    }


    @PostMapping ("/event")
    public ResponseEntity<Double> triggerEvent(@RequestBody GameEvent event) {
        //chargeRequest.setEventId(chargeRequest.getPlayerId().concat(String.valueOf(System.currentTimeMillis())));
        Double remainingBalance = gameAccountService.triggerEvent(event);
        return ResponseEntity.ok(remainingBalance);
    }

}
