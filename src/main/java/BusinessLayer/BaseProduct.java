package BusinessLayer;

import java.util.ArrayList;

public class BaseProduct extends  MenuItem {

    private String name;
    private Double price;
    public BaseProduct(String name,Double price)
    {
        super(name,price);
        this.name=name;
        this.price=price;
    }


    public Double computePrice() {
        return this.price;
    }
    public String getName()
    {
        return this.name;
    }

    @Override
    public ArrayList<MenuItem> getBaseProducts() {
        return null;
    }

    @Override
    public void removeMenuItem(String s) {

    }

    public void setName(String name)
    {
        this.name=name;
    }

    @Override
    public void removeAll() {

    }

    public void setPrice(Double price)
    {
        this.price=price;
    }

    @Override
    public boolean containsMenuItem(String s) {
        return false;
    }


}
