package fi.handson.gamengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "fi.handson.gamengine")
public class GameEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameEngineApplication.class, args);
	}

}
