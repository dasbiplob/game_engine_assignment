package fi.handson.gamengine.service;

import fi.handson.gamengine.model.*;
import fi.handson.gamengine.repository.CustomerRepository;
import fi.handson.gamengine.repository.GameAccountRepository;
import fi.handson.gamengine.repository.GameEventRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GameAccountService {

    private final CustomerRepository customerRepository;
    private final GameAccountRepository gameAccountRepository;
    private final GameEventRepository gameEventRepository;
    @Autowired
    public GameAccountService(CustomerRepository customerRepository, GameAccountRepository gameAccountRepository, GameEventRepository gameEventRepository) {
        this.gameAccountRepository = gameAccountRepository;
        this.customerRepository = customerRepository;
        this.gameEventRepository = gameEventRepository;
    }

    public Double triggerEvent(GameEvent event) {
        String customerId = gameAccountRepository.findCustomerId(event.getPlayer_id());
        Double accountBalance = customerRepository.findAccountBalance(customerId);
        if(StringUtils.isNotEmpty(event.getEvent_type())&&(event.getEvent_type()
                .equalsIgnoreCase("PURCHASE")|| event.getEvent_type().equalsIgnoreCase("WIN")))
            gameEventRepository.save(event);
        else
            throw new RuntimeException("Event type is not proper");

        if(StringUtils.trimToEmpty(event.getEvent_type()).equalsIgnoreCase("PURCHASE") && event.getAmount()<= accountBalance){
            accountBalance= accountBalance-event.getAmount();

        }else{
            accountBalance= accountBalance+event.getAmount();
        }
        return accountBalance;

    }


}
