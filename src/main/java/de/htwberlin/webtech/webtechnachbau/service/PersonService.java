package de.htwberlin.webtech.webtechnachbau.service;

import de.htwberlin.webtech.webtechnachbau.persistence.PersonEntity;
import de.htwberlin.webtech.webtechnachbau.persistence.PersonRepository;
import de.htwberlin.webtech.webtechnachbau.web.api.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*
Controller sollte sich idealerweise stets an einen Service wenden, der potenziell auch Business Logik ausführen könnte.
Business Logik (z.B. die Ausgabe aller Personen) sollte niemals im Controller stattfinden. Deswegen werden auch
Repositorys nicht im Controller aufgerufen, sondern im Service.
 */
@Service
public class PersonService {

    // Hiermit wird PersonRepository injected, wodurch ein Zugriff auf die Datenbanktabelle "persons" möglich ist
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // Methode gibt alle PErsonen, welche in der Tabelle "persons" sind, zurück
    public List<Person> findAll() {
        // Liste mit allen Personen erstellen
        List<PersonEntity> persons = personRepository.findAll();

        // Transformation zwischen den Datenmodellen
        return persons.stream().map(personsEntity -> new Person(personsEntity.getId(),
                                                                personsEntity.getFirstName(),
                                                                personsEntity.getLastName(),
                                                                personsEntity.getVaccinated())
                                    ).collect(Collectors.toList());
    }
}
