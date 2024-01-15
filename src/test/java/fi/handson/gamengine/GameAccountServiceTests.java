package fi.handson.gamengine;

import fi.handson.gamengine.model.GameEvent;
import fi.handson.gamengine.repository.CustomerRepository;
import fi.handson.gamengine.repository.GameAccountRepository;
import fi.handson.gamengine.repository.GameEventRepository;
import fi.handson.gamengine.service.GameAccountService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
class GameAccountServiceTests {

	// Mocking dependencies for GameAccountService
	@Mock
	private CustomerRepository customerRepository;

	@Mock
	private GameAccountRepository gameAccountRepository;

	@Mock
	private GameEventRepository gameEventRepository;

	// Injecting the mocks into the GameAccountService instance
	@InjectMocks
	private GameAccountService gameAccountService;

	// Test case for a successful purchase event
	@Test
	void testTriggerEventForPurchaseSuccess() {
		// Arrange
		GameEvent event = new GameEvent("player1", "PURCHASE", 10.5, "customer1");

		// Mocking behavior for repository calls
		when(gameAccountRepository.findCustomerId("player1")).thenReturn("customer1");
		when(customerRepository.findAccountBalance("customer1")).thenReturn(20.0);
		when(gameEventRepository.save(event)).thenReturn(event);  // Modified line

		// Act
		Double result = gameAccountService.triggerEvent(event);

		// Assert
		assertEquals(9.5, result);
		verify(gameEventRepository, times(1)).save(event);
	}


	// Test case for a successful win event
	@Test
	void testTriggerEventForWinSuccess() {
		// Arrange
		GameEvent event = new GameEvent("player1", "WIN", 10.5, "customer1");

		// Mocking behavior for repository calls
		when(gameAccountRepository.findCustomerId("player1")).thenReturn("customer1");
		when(customerRepository.findAccountBalance("customer1")).thenReturn(20.0);
		when(gameEventRepository.save(event)).thenReturn(event);  // Modified line

		// Act
		Double result = gameAccountService.triggerEvent(event);

		// Assert
		assertEquals(30.5, result);
		verify(gameEventRepository, times(1)).save(event);
	}


	// Test case for an invalid event type
	@Test
	void testTriggerEventInvalidEventType() {
		// Arrange
		GameEvent event = new GameEvent("player1", "INVALID_EVENT", 10.5, "customer1");

		// Act and Assert
		// Verifying that the service throws an exception for an invalid event type
		RuntimeException exception = assertThrows(RuntimeException.class, () -> {
			gameAccountService.triggerEvent(event);
		});

		// Asserting the exception message
		assertEquals("Event type is not proper", exception.getMessage());
		// Verifying that the save method was never called for an invalid event
		verify(gameEventRepository, never()).save(event);
	}

}
