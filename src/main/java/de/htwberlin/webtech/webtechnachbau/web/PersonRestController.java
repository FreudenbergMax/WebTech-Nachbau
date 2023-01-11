package de.htwberlin.webtech.webtechnachbau.web;

import de.htwberlin.webtech.webtechnachbau.web.api.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Der Controller dient dazu, dem Client die angeforderte HTML-Seite zu übermitteln
 */
@RestController
public class PersonRestController {

    private List<Person> persons;

    public PersonRestController() {
        this.persons = new ArrayList<>();
        this.persons.add(new Person(1, "Max", "Mustermann", false));
        this.persons.add(new Person(2, "Maxima", "Meier", true));
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
    public List<Person> fetchPersons() {

        return this.persons;
    }

}
