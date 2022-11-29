package de.htwberlin.webtech.webtechnachbau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hauptprogramm, welches die Web-Anwendung startet. Diese Klasse muss ausgeführt werden, damit man die Webseite
 * aufrufen kann
 */
@SpringBootApplication
public class WebtechNachbauApplication {

	public static void main(String[] args) {

		SpringApplication.run(WebtechNachbauApplication.class, args);
	}

}
