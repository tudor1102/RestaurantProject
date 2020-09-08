package BusinessLayer;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class MenuItem implements Serializable {
    private String name;
   private Double price;
    public MenuItem(String name,Double price)
    {
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
    public abstract ArrayList<MenuItem> getBaseProducts();
    public abstract void removeMenuItem(String s);

    public void setName(String name)
    {
        this.name=name;
    }
    public abstract void removeAll();
    public void setPrice(Double price)
    {
        this.price=price;
    }
    public abstract boolean containsMenuItem(String s);
}
