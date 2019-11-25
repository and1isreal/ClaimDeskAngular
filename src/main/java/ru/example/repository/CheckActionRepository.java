package ru.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.example.model.CheckAction;

import java.util.List;

public interface CheckActionRepository extends JpaRepository<CheckAction, Integer> {
    @Query("select c from CheckAction c where id_Check = ?1")
    List<CheckAction> findByIdCheck(Integer id);

}

