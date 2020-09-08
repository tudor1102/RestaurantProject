package BusinessLayer;

import java.util.ArrayList;
import java.util.Iterator;

public class CompositeProduct extends MenuItem{
    private String name;
    private Double price;
    private ArrayList<MenuItem> baseProducts;
    public CompositeProduct(String name,Double price)
    {
        super(name,price);
        this.name=name;
        this.price=price;
        this.baseProducts=new ArrayList<MenuItem>();
    }

    public Double computePrice()
    {
       double price=0;
        for(MenuItem i:this.baseProducts)
        {
            if (i !=null)
            price+=i.computePrice();
        }
        return price;
    }
    public Double getPrice()
    {
        return this.price;
    }
    public String getCompProductName()
    {
       return super.getName();
    }
    public void setName(String name){this.name=name;}

    @Override
    public void removeAll() {
        Iterator<MenuItem> iterator=this.baseProducts.iterator();
        while(iterator.hasNext())
        {
            iterator.remove();
        }
    }

    public void setPrice(Double price){this.price=price;}

    @Override
        public boolean containsMenuItem(String s) {
        boolean found=false;
        Iterator<MenuItem> it=this.baseProducts.iterator();
       while(it.hasNext())
        {
            if (it.next().getName().equals(s))
            {
                found=true;
                break;
            }
        }
        return found;
    }

    public ArrayList<MenuItem> getBaseProducts() {
        return baseProducts;
    }

    @Override
    public void removeMenuItem(String s) {
        Iterator<MenuItem> iterator=this.baseProducts.iterator();
        while(iterator.hasNext())
        {
            if (iterator.next().getName().equals(s))
            {
                iterator.remove();
            }
        }
    }
}
