package ru.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.example.model.Check;

import java.util.List;

public interface CheckRepository extends JpaRepository<Check, Integer> {

    @Query("SELECT c.idCheck FROM Check c WHERE c.idCheckList = ?1")
    List<Integer> findChecksByIdCheckList(Integer id);

    @Query("SELECT c FROM Check c WHERE c.idCheck = ?1")
    Check findCheckByIdCheck(int id);



    Check findTopByOrderByIdCheckDesc();

}
