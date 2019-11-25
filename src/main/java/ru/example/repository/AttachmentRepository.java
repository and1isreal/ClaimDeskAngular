package ru.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.model.Attachment;

import java.util.List;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
    default List<Attachment> getLastAttachments(int i) {
        List<Attachment> attachments = this.findAll();
        List<Attachment> attachmentList = attachments.subList(attachments.size() - i, attachments.size());
        return attachmentList;
    }
}
