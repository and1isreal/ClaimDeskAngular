package ru.example;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CheckForm {

    private Long idCheckList;

    private String name;

    private Timestamp start;

    private Timestamp finish;

    private Timestamp deadline;

    private Integer idEngineer;

    private Integer responible;
}
