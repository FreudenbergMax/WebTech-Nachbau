package de.htwberlin.webtech.webtechnachbau.persistence;

import javax.persistence.*;

/*
Es mag doppelt gemoppelt sein, dass es sowohl eine Klasse Person und eine Klasse PersonEntity gibt. Dies ist
beabsichtigt, weil man eine Trennung zwischen Datendefinition (Person) und dem Datenmodell (PersonEntity) haben möchte.
Person gehört der REST-Schnittstelle. Die PersonEntity bildet 1-zu-1 eine Tabelle ab.
 */

// Name der Tabelle lautet "persons"
@Entity(name = "persons")
public class PersonEntity {

    // Jeder der Attribute ist eine Spalte in der Tabelle "persons"

    @Id                                                     // bestimmt, dass id der Primärschlüssel ist
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // generiert automatisch einen numerischen Wert, der um 1 hoch zählt
    @Column(name = "id")                                    // definiert Attribut als Tabellenspalte
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "vaccinated")
    private Boolean vaccinated;

    // Konstruktor wird benötigt, um Entitäten in der Anwendung erzeugen zu können
    public PersonEntity(String firstName, String lastName, Boolean vaccinated) {
        // id ist eigentlich überflüssig, da diese ja von der Datenbank generiert werden soll
        this.firstName = firstName;
        this.lastName = lastName;
        this.vaccinated = vaccinated;
    }

    // Der parameterlose Konstruktor wird im Hintergrund benötigt, damit OR-Mapping mit Hibernate funktioniert
    protected PersonEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(Boolean vaccinated) {
        this.vaccinated = vaccinated;
    }
}
