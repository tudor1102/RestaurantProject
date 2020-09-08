package BusinessLayer;

import java.util.Objects;

public class Order {
    private int ID;
    private String date;
    private int tableNum;
    public Order(int ID,String date,int tableNum)
    {
        this.ID=ID;
        this.date=date;
        this.tableNum=tableNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return ID == order.ID &&
                tableNum == order.tableNum &&
                Objects.equals(date, order.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, date, tableNum);
    }

    public int getID()
    {
        return this.ID;
    }

    public int getTableNum() {
        return tableNum;
    }

    public String getDate() {
        return date;
    }

    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
