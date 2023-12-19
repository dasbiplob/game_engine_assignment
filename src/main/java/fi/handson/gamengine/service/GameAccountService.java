package fi.handson.gamengine.service;

import fi.handson.gamengine.model.*;
import fi.handson.gamengine.repository.CustomerRepository;
import fi.handson.gamengine.repository.GameAccountRepository;
import fi.handson.gamengine.repository.GameEventRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Service class responsible for handling game account-related operations.
 */

@Service
public class GameAccountService {

    private final CustomerRepository customerRepository;
    private final GameAccountRepository gameAccountRepository;
    private final GameEventRepository gameEventRepository;

    /**
     * Constructor for GameAccountService.
     *
     * @param customerRepository    Repository for managing customer-related data.
     * @param gameAccountRepository Repository for managing game account-related data.
     * @param gameEventRepository   Repository for managing game event-related data.
     */
    @Autowired
    public GameAccountService(CustomerRepository customerRepository, GameAccountRepository gameAccountRepository, GameEventRepository gameEventRepository) {
        this.gameAccountRepository = gameAccountRepository;
        this.customerRepository = customerRepository;
        this.gameEventRepository = gameEventRepository;
    }

    /**
     * Triggers a game event and updates the account balance based on the event type.
     *
     * @param event The game event to be triggered.
     * @return The updated account balance after processing the event.
     */
    public Double triggerEvent(GameEvent event) {
        // Find the customer ID associated with the player ID from the game account repository.
        String customerId = gameAccountRepository.findCustomerId(event.getPlayer_id());
        // Find the current account balance of the customer.
        Double accountBalance = customerRepository.findAccountBalance(customerId);
        // Validate the event type and save the event if it is a valid type (PURCHASE or WIN).
        if(StringUtils.isNotEmpty(event.getEvent_type())&&(event.getEvent_type()
                .equalsIgnoreCase("PURCHASE")|| event.getEvent_type().equalsIgnoreCase("WIN")))
            gameEventRepository.save(event);
        else
            throw new RuntimeException("Event type is not proper");
        // Update the account balance based on the event type and amount.
        if(StringUtils.trimToEmpty(event.getEvent_type()).equalsIgnoreCase("PURCHASE") && event.getAmount()<= accountBalance){
            accountBalance= accountBalance-event.getAmount();

        }else{
            accountBalance= accountBalance+event.getAmount();
        }
        // Return the updated account balance.
        return accountBalance;

    }


}
