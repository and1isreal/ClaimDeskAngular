package ru.example.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@IdClass(CheckActionAttachment.class)
@Table(name = "Check_Action_Attachment")
public class CheckActionAttachment implements Serializable {

    @Id
    private int id_Check_Action;

    @Id
    private int id_Attachment;

}
