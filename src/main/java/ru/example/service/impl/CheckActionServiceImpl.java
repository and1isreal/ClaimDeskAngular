package ru.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.model.CheckAction;
import ru.example.repository.CheckActionRepository;
import ru.example.service.CheckActionService;

import java.util.List;
import java.util.Set;

@Service
public class CheckActionServiceImpl implements CheckActionService {

    @Autowired
    private CheckActionRepository checkActionRepository;

    @Override
    public List<CheckAction> findByIdCheck(Integer id) {
        return checkActionRepository.findByIdCheck(id);
    }

    @Override
    public void addCheckAction(CheckAction checkAction) {
        checkActionRepository.save(checkAction);
    }

    @Override
    public List<CheckAction> addAllCheckActions(Set<CheckAction> checkActionSet) {
        return checkActionRepository.saveAll(checkActionSet);
    }

    @Override
    public void removeByIdCheck(Integer id) {
        checkActionRepository.deleteById(id);
    }

    @Override
    public List<CheckAction> findAllCheckActions() {
        return checkActionRepository.findAll();
    }

}
