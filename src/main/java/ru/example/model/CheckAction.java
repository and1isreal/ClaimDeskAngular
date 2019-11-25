package ru.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.Set;

//@Data
@Table(name = "Check_Action")
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property  = "id_Check_Action",
        scope     = Integer.class)
public class CheckAction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Check_Action")
    private Integer id_Check_Action;

//    @Column(name = "ID_Check")
//    private Integer id_Check;

    @Column(name = "ID_Check_Item")
    private Integer id_Check_Item;

    @Column(name = "ID_Maintenance_Action")
    private Integer id_Maintenance_Action;

    @Column(name = "Action_Date")
    private Timestamp action_Date;

    @Column(name = "Acted")
    private Integer acted;

    @Column(name = "ID_Engineer")
    private Integer id_Engineer;

    @Column(name = "Action_Time")
    private Integer action_Time;

    @Column(name = "Parameter")
    private String parameter;

    @Column(name = "Name")
    private String name;

    @Column(name = "SortOrder")
    private Integer sort_Order;

    @Column(name = "Action_Name")
    private String action_Name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Need_Photo")
    private Integer need_Photo;

    @Column(name = "Need_Parameter")
    private Integer need_Parameter;

    @Column(name = "Item_SortOrder")
    private Integer item_SortOrder;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_Check")
    private Check check;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "Check_Action_Attachment", joinColumns = {
            @JoinColumn(name = "ID_Check_Action", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "ID_Attachment",
                    nullable = false, updatable = false) })
    private List<Attachment> attachments;

    public CheckAction() {
    }

    public CheckAction(Integer id_Check_Item, Integer id_Maintenance_Action, Timestamp action_Date, Integer acted, Integer id_Engineer, Integer action_Time, String parameter, String name, Integer sort_Order, String action_Name, String description, Integer need_Photo, Integer need_Parameter, Integer item_SortOrder, Check check) {
        this.id_Check_Item = id_Check_Item;
        this.id_Maintenance_Action = id_Maintenance_Action;
        this.action_Date = action_Date;
        this.acted = acted;
        this.id_Engineer = id_Engineer;
        this.action_Time = action_Time;
        this.parameter = parameter;
        this.name = name;
        this.sort_Order = sort_Order;
        this.action_Name = action_Name;
        this.description = description;
        this.need_Photo = need_Photo;
        this.need_Parameter = need_Parameter;
        this.item_SortOrder = item_SortOrder;
        this.check = check;
    }

    public Integer getId_Check_Action() {
        return id_Check_Action;
    }

    public void setId_Check_Action(Integer id_Check_Action) {
        this.id_Check_Action = id_Check_Action;
    }

    public Integer getId_Check_Item() {
        return id_Check_Item;
    }

    public void setId_Check_Item(Integer id_Check_Item) {
        this.id_Check_Item = id_Check_Item;
    }

    public Integer getId_Maintenance_Action() {
        return id_Maintenance_Action;
    }

    public void setId_Maintenance_Action(Integer id_Maintenance_Action) {
        this.id_Maintenance_Action = id_Maintenance_Action;
    }

    public Timestamp getAction_Date() {
        return action_Date;
    }

    public void setAction_Date(Timestamp action_Date) {
        this.action_Date = action_Date;
    }

    public Integer getActed() {
        return acted;
    }

    public void setActed(Integer acted) {
        this.acted = acted;
    }

    public Integer getId_Engineer() {
        return id_Engineer;
    }

    public void setId_Engineer(Integer id_Engineer) {
        this.id_Engineer = id_Engineer;
    }

    public Integer getAction_Time() {
        return action_Time;
    }

    public void setAction_Time(Integer action_Time) {
        this.action_Time = action_Time;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort_Order() {
        return sort_Order;
    }

    public void setSort_Order(Integer sort_Order) {
        this.sort_Order = sort_Order;
    }

    public String getAction_Name() {
        return action_Name;
    }

    public void setAction_Name(String action_Name) {
        this.action_Name = action_Name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNeed_Photo() {
        return need_Photo;
    }

    public void setNeed_Photo(Integer need_Photo) {
        this.need_Photo = need_Photo;
    }

    public Integer getNeed_Parameter() {
        return need_Parameter;
    }

    public void setNeed_Parameter(Integer need_Parameter) {
        this.need_Parameter = need_Parameter;
    }

    public Integer getItem_SortOrder() {
        return item_SortOrder;
    }

    public void setItem_SortOrder(Integer item_SortOrder) {
        this.item_SortOrder = item_SortOrder;
    }

    public Check getCheck() {
        return check;
    }

    public void setCheck(Check check) {
        this.check = check;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    @Override
    public String toString() {
        return "CheckAction{" +
                "id_Check_Action=" + id_Check_Action +
                ", id_Check_Item=" + id_Check_Item +
                ", id_Maintenance_Action=" + id_Maintenance_Action +
                ", action_Date=" + action_Date +
                ", acted=" + acted +
                ", id_Engineer=" + id_Engineer +
                ", action_Time=" + action_Time +
                ", parameter='" + parameter + '\'' +
                ", name='" + name + '\'' +
                ", sort_Order=" + sort_Order +
                ", action_Name='" + action_Name + '\'' +
                ", description='" + description + '\'' +
                ", need_Photo=" + need_Photo +
                ", need_Parameter=" + need_Parameter +
                ", item_SortOrder=" + item_SortOrder +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckAction that = (CheckAction) o;
        return Objects.equals(id_Check_Action, that.id_Check_Action) &&
                Objects.equals(id_Check_Item, that.id_Check_Item) &&
                Objects.equals(id_Maintenance_Action, that.id_Maintenance_Action) &&
                Objects.equals(action_Date, that.action_Date) &&
                Objects.equals(acted, that.acted) &&
                Objects.equals(id_Engineer, that.id_Engineer) &&
                Objects.equals(action_Time, that.action_Time) &&
                Objects.equals(parameter, that.parameter) &&
                Objects.equals(name, that.name) &&
                Objects.equals(sort_Order, that.sort_Order) &&
                Objects.equals(action_Name, that.action_Name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(need_Photo, that.need_Photo) &&
                Objects.equals(need_Parameter, that.need_Parameter) &&
                Objects.equals(item_SortOrder, that.item_SortOrder) &&
                Objects.equals(check, that.check) &&
                Objects.equals(attachments, that.attachments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_Check_Action, id_Check_Item, id_Maintenance_Action, action_Date, acted, id_Engineer, action_Time, parameter, name, sort_Order, action_Name, description, need_Photo, need_Parameter, item_SortOrder, check, attachments);
    }
}
