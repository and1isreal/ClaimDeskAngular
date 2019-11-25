package ru.example.service;


import ru.example.model.CheckActionAttachment;

import java.util.List;

public interface CheckActionAttachmentService {
    List<CheckActionAttachment> findCheckActionAttachmentsById_Check_Actions(List<Integer> list);
    void addCheckActionAttachment(CheckActionAttachment checkActionAttachment);
}
