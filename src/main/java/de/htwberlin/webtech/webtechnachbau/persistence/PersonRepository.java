package de.htwberlin.webtech.webtechnachbau.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
PersonRepository dient dazu, den PersonRestController mit der Datenbank zu verbinden. So kann der PersonRestController
die Personen nun direkt aus der Datenbank beziehen oder hinzufügen

JpaRepository benötigt zwei Typen: den Entitätstyp (hier: PersonEntity) und Datentyp des Primärschlüssels (hier: Long,
da das Attribut "id" diesen Datentyp hat))
 */
@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    // generiert SQL-Befehl, der alle Vornamen in der Tabelle "persons" zurückgibt
    List<PersonEntity> findAllByFirstName(String firstName);

}
