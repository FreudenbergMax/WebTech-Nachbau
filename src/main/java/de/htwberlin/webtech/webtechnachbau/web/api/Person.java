package de.htwberlin.webtech.webtechnachbau.web.api;

/*
Diese Klasse dient als Ressource bzw. als REST-Endpunkt für die API-Schnittstelle

Es mag doppelt gemoppelt sein, dass es sowohl eine Klasse Person und eine Klasse PersonEntity gibt. Dies ist
beabsichtigt, weil man eine Trennung zwischen Datendefinition (Person) und dem Datenmodell (PersonEntity) haben möchte.
Person gehört der REST-Schnittstelle. Die PersonEntity bildet 1-zu-1 eine Tabelle ab.

 */
public class Person {

    private long id;
    private String firstName;
    private String lastName;
    private boolean vaccinated;

    public Person(long id, String firstName, String lastName, boolean vaccinated) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.vaccinated = vaccinated;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }
}
