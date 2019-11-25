package ru.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.model.CheckList;

import java.util.Optional;

public interface CheckListRepository extends JpaRepository<CheckList, Integer> {

    default String getNameById(int id) {
        Optional<CheckList> checkList = this.findById(id);
        return checkList.isPresent()? checkList.get().getName() : "no name";
    }
}
