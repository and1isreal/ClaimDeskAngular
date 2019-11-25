package ru.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.model.CheckActionAttachment;
import ru.example.repository.CheckActionAttachmentRepository;
import ru.example.service.CheckActionAttachmentService;

import java.util.List;

@Service
public class CheckActionAttachmentServiceImpl implements CheckActionAttachmentService {

    @Autowired
    private CheckActionAttachmentRepository checkActionAttachmentRepository;

    @Override
    public List<CheckActionAttachment> findCheckActionAttachmentsById_Check_Actions(List<Integer> list) {
        return checkActionAttachmentRepository.findCheckActionAttachmentsById_Check_Actions(list);
    }

    @Override
    public void addCheckActionAttachment(CheckActionAttachment checkActionAttachment) {
        checkActionAttachmentRepository.save(checkActionAttachment);
    }
}
