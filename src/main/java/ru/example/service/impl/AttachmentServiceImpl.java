package ru.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.model.Attachment;
import ru.example.repository.AttachmentRepository;
import ru.example.service.AttachmentService;

import java.util.List;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    AttachmentRepository attachmentRepository;

    @Override
    public List<Attachment> findAllAttachments() {
        return attachmentRepository.findAll();
    }

    @Override
    public Attachment findById(int id) {
        return attachmentRepository.findById(id).get();
    }

    @Override
    public List<Attachment> addAllAttachments(List<Attachment> attachments) {
        return attachmentRepository.saveAll(attachments);
    }
}
