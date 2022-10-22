package cdp;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"albamon", "common.standard", "cdp"})
public class MulitiGradleApiApplication {

	public static void main(String[] args) {
		System.setProperty("timestamp", String.valueOf(LocalDateTime.now()));

		SpringApplication.run(MulitiGradleApiApplication.class, args);
	}
}
