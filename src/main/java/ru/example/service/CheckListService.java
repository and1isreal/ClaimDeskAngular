package ru.example.service;


import ru.example.model.CheckList;

import java.util.List;
import java.util.Optional;

public interface CheckListService {
    List<CheckList> findAllCheckLists();
    Optional<CheckList> findById(Integer id);
    String getNameById(Integer id);
}
