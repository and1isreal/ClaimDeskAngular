package ru.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.model.Engineer;

public interface EngineerRepository extends JpaRepository<Engineer, Integer> {

    Engineer findByName(String name);
}
