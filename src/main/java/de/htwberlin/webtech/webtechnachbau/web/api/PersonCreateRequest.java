package de.htwberlin.webtech.webtechnachbau.web.api;

/**
 * Diese Klasse wird für die Post-Methode "createPerson" in "PersonRestController" erstellt. Hier werden die Attribute
 * genannt, die der Client (PersonRestController) an die Datenbank übermitteln darf. Da die ID als Primärschlüssel
 * von der Datenbank generiert wird, soll die ID nicht mit übermittelt werden.
 */
public class PersonCreateRequest {

    private String firstName;
    private String lastName;
    private boolean vaccinated;

    public PersonCreateRequest(String firstName, String lastName, boolean vaccinated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.vaccinated = vaccinated;
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
