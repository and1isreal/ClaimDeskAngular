package ru.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.model.CheckList;
import ru.example.repository.CheckListRepository;
import ru.example.service.CheckListService;

import java.util.List;
import java.util.Optional;


@Service
public class CheckListServiceImpl implements CheckListService {

    @Autowired
    private CheckListRepository checkListRepository;

    @Override
    public List<CheckList> findAllCheckLists() {
        return checkListRepository.findAll();
    }

    @Override
    public Optional<CheckList> findById(Integer id) {
        return checkListRepository.findById(id);
    }

    @Override
    public String getNameById(Integer id) {
        return checkListRepository.getNameById(id);
    }
}
