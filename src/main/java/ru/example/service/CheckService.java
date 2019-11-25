package ru.example.service;

import ru.example.model.Check;

import java.util.List;

public interface CheckService {
    void addCheck(Check check);
    void deleteCheckById(int id);
    List<Check> findAllChecks();
    Check getLastCheck();
    List<Integer> findChecksByIdCheckList(Integer id);
    Check findCheckById(Integer id);
    void deleteCheck(Check check);

    void changeCheck(Check check);
}
