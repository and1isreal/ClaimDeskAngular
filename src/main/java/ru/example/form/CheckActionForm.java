package ru.example.form;
import ru.example.model.CheckAction;
import java.sql.Timestamp;
import java.util.Objects;

public class CheckActionForm {

    private Integer id_Check_Item;

    private Integer id_Maintenance_Action;

    private Timestamp action_Date;

    private Integer acted;

    private Integer id_Engineer;

    private Integer action_Time;

    private String parameter;

    private String name;

    private Integer sort_Order;

    private String action_Name;

    private String description;

    private Integer need_Photo;

    private Integer need_Parameter;

    private Integer item_SortOrder;

    public CheckActionForm(CheckAction checkAction) {
        this.id_Check_Item = checkAction.getId_Check_Item();
        this.id_Maintenance_Action = checkAction.getId_Maintenance_Action();
        this.action_Date = checkAction.getAction_Date();
        this.acted = checkAction.getActed();
        this.id_Engineer = checkAction.getId_Engineer();
        this.action_Time = checkAction.getAction_Time();
        this.parameter = checkAction.getParameter();
        this.name = checkAction.getName();
        this.sort_Order = checkAction.getSort_Order();
        this.action_Name = checkAction.getAction_Name();
        this.description = checkAction.getDescription();
        this.need_Parameter = checkAction.getNeed_Parameter();
        this.need_Photo = checkAction.getNeed_Photo();
        this.item_SortOrder = checkAction.getItem_SortOrder();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckActionForm that = (CheckActionForm) o;
        return Objects.equals(id_Check_Item, that.id_Check_Item) &&
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
                Objects.equals(item_SortOrder, that.item_SortOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_Check_Item, id_Maintenance_Action, action_Date, acted, id_Engineer, action_Time, parameter, name, sort_Order, action_Name, description, need_Photo, need_Parameter, item_SortOrder);
    }

    @Override
    public String toString() {
        return "CheckActionForm{" +
                "id_Check_Item=" + id_Check_Item +
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
}
