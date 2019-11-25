package ru.example.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "Engineer")
@Entity
public class Engineer {

    @Id
    @Column(name = "ID_Engineer")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "Name")
    private String name;
}
