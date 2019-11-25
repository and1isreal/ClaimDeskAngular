package ru.example.model;

import com.fasterxml.jackson.annotation.*;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Table(name = "Checks")
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property  = "idCheck",
        scope     = Integer.class)
public class Check implements Serializable {

    @Id
    @Column(name = "ID_Check")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCheck;

    @Column(name = "ID_Check_List")
    private Integer idCheckList;

    @Column(name = "Name")
    private String name;

    @Column(name = "Start_Date")
    private Timestamp start;

    @Column(name = "Finish_Date")
    private Timestamp finish;

    @Column(name = "Deadline")
    private Timestamp deadline;

    @Column(name = "ID_Engineer")
    private Integer idEngineer;

    @Column(name = "Responsible")
    private Integer responible;

    @OneToMany(mappedBy = "check",orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CheckAction> checkActionList;

    public Check() {
    }

    public Check(Integer idCheckList, Timestamp start, Timestamp finish, Timestamp deadline, Integer idEngineer) {
        this.idCheckList = idCheckList;
        this.start = start;
        this.finish = finish;
        this.deadline = deadline;
        this.idEngineer = idEngineer;
    }

    public Integer getIdCheck() {
        return idCheck;
    }

    public void setIdCheck(Integer idCheck) {
        this.idCheck = idCheck;
    }

    public Integer getIdCheckList() {
        return idCheckList;
    }

    public void setIdCheckList(Integer idCheckList) {
        this.idCheckList = idCheckList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getFinish() {
        return finish;
    }

    public void setFinish(Timestamp finish) {
        this.finish = finish;
    }

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    public Integer getIdEngineer() {
        return idEngineer;
    }

    public void setIdEngineer(Integer idEngineer) {
        this.idEngineer = idEngineer;
    }

    public Integer getResponible() {
        return responible;
    }

    public void setResponible(Integer responible) {
        this.responible = responible;
    }

    public List<CheckAction> getCheckActionList() {
        return checkActionList;
    }

    public void setCheckActionList(List<CheckAction> checkActionList) {
        this.checkActionList = checkActionList;
    }

    @Override
    public String toString() {
        return "Check{" +
                "idCheck=" + idCheck +
                ", idCheckList=" + idCheckList +
                ", name='" + name + '\'' +
                ", start=" + start +
                ", finish=" + finish +
                ", deadline=" + deadline +
                ", idEngineer=" + idEngineer +
                ", responible=" + responible +
//                ", checkActionSet=" + checkActionSet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Check check = (Check) o;
        return Objects.equals(idCheck, check.idCheck) &&
                Objects.equals(idCheckList, check.idCheckList) &&
                Objects.equals(name, check.name) &&
                Objects.equals(start, check.start) &&
                Objects.equals(finish, check.finish) &&
                Objects.equals(deadline, check.deadline) &&
                Objects.equals(idEngineer, check.idEngineer) &&
                Objects.equals(responible, check.responible) &&
                Objects.equals(checkActionList, check.checkActionList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCheck, idCheckList, name, start, finish, deadline, idEngineer, responible, checkActionList);
    }
}
