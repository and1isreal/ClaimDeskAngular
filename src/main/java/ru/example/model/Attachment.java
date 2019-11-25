package ru.example.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Attachment")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property  = "id_Attachment",
        scope     = Integer.class)
public class Attachment implements Serializable {

    public Attachment() {
    }

    public Attachment(String fileName, int graphic_Type) {
        this.fileName = fileName;
        this.graphic_Type = graphic_Type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Attachment;

    @Column(name = "FileNameReal")
    private String fileName;

    @Column(name = "Graphic_Type")
    private int graphic_Type;

    @Column(name = "Upd")
    private Timestamp upd;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "attachments")
    private List<CheckAction> checkActions;

    public Integer getId_Attachment() {
        return id_Attachment;
    }

    public void setId_Attachment(Integer id_Attachment) {
        this.id_Attachment = id_Attachment;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getGraphic_Type() {
        return graphic_Type;
    }

    public void setGraphic_Type(int graphic_Type) {
        this.graphic_Type = graphic_Type;
    }

    public Timestamp getUpd() {
        return upd;
    }

    public void setUpd(Timestamp upd) {
        this.upd = upd;
    }

    public List<CheckAction> getCheckActions() {
        return checkActions;
    }

    public void setCheckActions(List<CheckAction> checkActions) {
        this.checkActions = checkActions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attachment that = (Attachment) o;
        return id_Attachment == that.id_Attachment &&
                graphic_Type == that.graphic_Type &&
                Objects.equals(fileName, that.fileName) &&
                Objects.equals(upd, that.upd) &&
                Objects.equals(checkActions, that.checkActions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_Attachment, fileName, graphic_Type, upd, checkActions);
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "id_Attachment=" + id_Attachment +
                ", fileName='" + fileName + '\'' +
                ", graphic_Type=" + graphic_Type +
                ", upd=" + upd +
                //", checkActions=" + checkActions +
                '}';
    }
}
