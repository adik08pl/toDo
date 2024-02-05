package com.stempien.toDo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

// Hermetyzacja + Lombok
@Entity
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String description;
    LocalDate deadline; // czemu string? why?
    public Tasks(){

    }
    public Tasks(String nazwa, String opis, LocalDate termin){
        this.name =nazwa;
        this.description =opis;
        this.deadline =termin;
    }
}
