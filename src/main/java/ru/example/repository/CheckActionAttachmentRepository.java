package ru.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.example.model.CheckActionAttachment;

import java.util.List;

public interface CheckActionAttachmentRepository extends JpaRepository<CheckActionAttachment, Integer> {
    @Query("select c from CheckActionAttachment c where id_Check_Action in :ids")
    List<CheckActionAttachment> findCheckActionAttachmentsById_Check_Actions(@Param("ids") List<Integer> list);
}
