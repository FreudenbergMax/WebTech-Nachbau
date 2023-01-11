package de.htwberlin.webtech.webtechnachbau.service;

import de.htwberlin.webtech.webtechnachbau.persistence.PersonEntity;
import de.htwberlin.webtech.webtechnachbau.persistence.PersonRepository;
import de.htwberlin.webtech.webtechnachbau.web.api.Person;
import de.htwberlin.webtech.webtechnachbau.web.api.PersonManipulationRequest;
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

    /**
     * @return Methode gibt alle Prsonen, welche in der Tabelle "persons" sind, zurück
     */
    public List<Person> findAll() {
        // Liste mit allen Personen erstellen
        List<PersonEntity> persons = personRepository.findAll();

        // Transformation zwischen den Datenmodellen
        return persons.stream().map(this::transformEntity).collect(Collectors.toList());
    }

    /**
     * Methode gibt eine Person aus Tabelle persons auf Grundlage der id zurück
     * @param id ID der Person, die zurückgegeben werden soll
     * @return Person, dessen ID übergeben wurde
     */
    public Person findById(Long id) {
        var personEntity = personRepository.findById(id);
        return personEntity.map(this::transformEntity).orElse(null);
    }

    /**
     * Methode erstellt eine neue Person, die PersonRestController über dessen Methode "createPerson" in die Datenbank
     * in dessen Tabelle "persons" schreibt
     * @return
     */
    public Person create(PersonManipulationRequest request) {

        // request wird in Entity gemappt
        var personEntity = new PersonEntity(request.getFirstName(), request.getLastName(), request.isVaccinated());
        personEntity = personRepository.save(personEntity);
        return transformEntity(personEntity);
    }

    /**
     * Methode aktualisiert Werte einer bereits vorhandenen Entität in der Datenbank. Methode wird dann von
     * PersonRestController in dessen Methode "updatePerson" verwendet, um die Aktualisierung vorzunehmen
     * @param id
     * @param request
     * @return
     */
    public Person update(Long id, PersonManipulationRequest request) {
        var personEntityOptional = personRepository.findById(id);

        // Falls ID bzw. Entity nicht existiert, null zurückgeben...
        if (personEntityOptional.isEmpty()) {
            return null;
        }

        // ... sonst wird Entity geholt
        var personEntity = personEntityOptional.get();

        // Entity wird aktualisiert
        personEntity.setFirstName(request.getFirstName());
        personEntity.setLastName(request.getLastName());
        personEntity.setVaccinated(request.isVaccinated());

        // Aktualisierung wird in Datenbank gespeichert
        personEntity = personRepository.save(personEntity);

        return transformEntity(personEntity);
    }

    /**
     * Methode mappt eine PersonEntity zu eine Person
     * @param personEntity welche in eine Person gemappt werden soll
     * @return Person, welche aus personEntity gemappt wurde
     */
    private Person transformEntity(PersonEntity personEntity) {
        return new Person(
                personEntity.getId(),
                personEntity.getFirstName(),
                personEntity.getLastName(),
                personEntity.getVaccinated()
        );
    }
}
