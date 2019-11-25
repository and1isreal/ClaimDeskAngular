package ru.example.service;


import ru.example.model.CheckAction;

import java.util.List;
import java.util.Set;

public interface CheckActionService {
    List<CheckAction> findByIdCheck(Integer id);
    void addCheckAction(CheckAction checkAction);
    List<CheckAction> addAllCheckActions(Set<CheckAction> checkActionSet);
    void removeByIdCheck(Integer id);
    List<CheckAction> findAllCheckActions();
}
