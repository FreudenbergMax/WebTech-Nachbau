package de.htwberlin.webtech.webtechnachbau.web;

import de.htwberlin.webtech.webtechnachbau.persistence.PersonRepository;
import de.htwberlin.webtech.webtechnachbau.service.PersonService;
import de.htwberlin.webtech.webtechnachbau.web.api.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Der Controller dient dazu, dem Client die angeforderte HTML-Seite zu übermitteln
 */
@RestController
public class PersonRestController {

    // Hiermit wird PersonRepository injected, wodurch ein Zugriff auf die Datenbanktabelle "persons" möglich ist
    private final PersonService personService;

    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * Methode verarbeitet GET-Request des Clients. Die angeforderte HTML-Seite wird zurückgegeben, wenn
     * im Browser "localhost:8080/api/v1/persons" angegeben wird.
     * Als Metadaten sollte bei REST-Schnittstellen ein Statuscode mit zurückgegeben werden, ob die Anfrage
     * geglückt ist. Deswegen wird der ResponseStatus verwendet. Das ist eine Wrapperklasse, die genau das zurückgibt-
     * @return Liste der in der Datenbank hinterlegten Personen
     */
    @GetMapping(path="/api/v1/persons")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<Person>> fetchPersons() {
        return ResponseEntity.ok(personService.findAll());
    }

}
