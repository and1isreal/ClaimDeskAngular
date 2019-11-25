package ru.example.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "Check_List")
@Entity
public class CheckList {

    @Id
    @Column(name = "ID_Check_List")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Name")
    private String name;

}