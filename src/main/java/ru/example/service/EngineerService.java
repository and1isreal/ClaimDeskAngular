package ru.example.service;

import ru.example.model.Engineer;

import java.util.List;

public interface EngineerService {
    List<Engineer> findAllEngineers();
    Engineer findByName(String name);
}
