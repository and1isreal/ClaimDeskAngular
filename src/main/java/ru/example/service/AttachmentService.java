package ru.example.service;

import ru.example.model.Attachment;

import java.util.List;

public interface AttachmentService {
    List<Attachment> findAllAttachments();
    Attachment findById(int id);
    List<Attachment> addAllAttachments(List<Attachment> attachments);
}
