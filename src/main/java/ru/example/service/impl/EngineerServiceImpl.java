package ru.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.model.Engineer;
import ru.example.repository.EngineerRepository;
import ru.example.service.EngineerService;

import java.util.List;

@Service
public class EngineerServiceImpl implements EngineerService {

    @Autowired
    private EngineerRepository engineerRepository;

    @Override
    public List<Engineer> findAllEngineers() {
        return engineerRepository.findAll();
    }

    @Override
    public Engineer findByName(String name) {
        return engineerRepository.findByName(name);
    }
}
