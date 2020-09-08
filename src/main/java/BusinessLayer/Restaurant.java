package BusinessLayer;
import DataLayer.FileWriterClass;
import java.awt.*;
import java.io.IOException;
import java.security.KeyStore;
import java.util.*;

/**
 * @invariant isWellFormed()
 */
public class Restaurant extends Observable implements IRestaurantProcessing {
    private ArrayList<MenuItem> menuItems = null;
    private HashMap<Order,ArrayList<MenuItem>> hashMap;
    public Restaurant() {
        this.menuItems = new ArrayList<MenuItem>();
        this.hashMap=new HashMap<Order,ArrayList<MenuItem>>();
    }
    public boolean isWellFormed()
    {
        boolean wellFormed=true;
        for(MenuItem i:this.menuItems)
        {
            if (i==null)
            {
                wellFormed=false;
                break;
            }
        }
        return wellFormed;
    }
    public void setMenuItems(ArrayList<MenuItem> menuItems)
    {
        //assert(menuItems==null):"Cannot set null objects";
        this.menuItems=menuItems;
    }
    public HashMap<Order,ArrayList<MenuItem>> getHashMap(){return this.hashMap;}
    public ArrayList<MenuItem> getMenuItems() {
        return this.menuItems;
    }
    public void addBaseProduct(MenuItem p) {
        assert(p!=null):"Cannot add a null object";
        this.menuItems.add(p);
    }
    public boolean checkForBaseProduct(String name) {
        assert(name!=null):"Base product name cannot be null";
        boolean found = false;
        for (MenuItem i : this.menuItems) {

            if (i.getName().equals(name) && i instanceof BaseProduct) {
                found = true;
                break;
            }
        }
        return found;
    }
    public BaseProduct getBaseProductWithName(String name) {
        assert(name!=null):"Composite product name cannot be null";
        MenuItem res = null;
        for (MenuItem i : this.menuItems) {
            if (i.getName().equals(name) && i instanceof BaseProduct) { res = i;break; }
        }
        return (BaseProduct) res;
    }
    public CompositeProduct getCompositeProductWithName(String name) {
        assert(name!=null):"Composite product name cannot be null";
        MenuItem res = null;
        for (MenuItem i : this.menuItems) {
            if (i.getName().equals(name) && i instanceof CompositeProduct) { res = i;break; }
        }
        return (CompositeProduct) res;
    }
    public boolean checkForMenuItemName(String name) {
        assert(name!=null):"Menu item cannot be null";
        boolean found = false;
        for (MenuItem i : this.menuItems) {

            if (i.getName().equals(name) && i instanceof CompositeProduct) {
                found = true;
                break;
            }
        }
        return found;
    }
    public MenuItem getMenuItemWithName(String s)
    {
        assert(s!=null):"Menu item name cannot be null";
        MenuItem toReturn=null;
        for(MenuItem i:this.menuItems)
        {
            if (i.getName().equals(s))
            {
                toReturn=i;
                break;
            }
        }
        return toReturn;
    }
    public int getNrOfProds() {
        int counter = 0;
        for (MenuItem i : this.menuItems) {
            if (i != null) counter++;
        }
        return counter;
    }
    public String[] getProducts() {
        int k = 0;
        String[] products = new String[this.getNrOfProds()];
        for (MenuItem i : this.menuItems) {
            if (i != null) {
                products[k++] = i.getName();
            }
        }
        return products;
    }
    public Double[] getPrices() {
        int k = 0;
        Double[] prices = new Double[this.getNrOfProds()];
        for (MenuItem i : this.menuItems) {
            if (i != null) {
                prices[k++] = i.computePrice();
            }
        }
        return prices;
    }

    /**
     *
     * @param menuItem este un parametru de tipul MenuItem ce va fi adaugat la lista responsabila de produse.
     */
    public void addMenuItem(MenuItem menuItem)  {
        assert(menuItem!=null):"Menu item cannot be a null object!";
        this.menuItems.add(menuItem);
    }

    /**
     *
     * @param menuItem parametru de tip menuItem care va fi cautat in lista de produse si va fi sters.
     */
    @Override

    public void deleteCompProdItem(MenuItem menuItem) {
            assert(menuItem!=null):"Cannot delete an item that does not exist";
            this.menuItems.remove(menuItem);
            deleteCompProdItem(menuItem);
    }

    /**
     *
     * @param menuItem parametru de tip menuItem care va fi cautat in lista de produse si va fi sters.
     */
    @Override
    public void deleteMenuItem(MenuItem menuItem)
    {
          assert(menuItem!=null):"Cannot delete an item that does not exist";
        ArrayList<MenuItem> listToDel=new ArrayList<MenuItem>();
        Iterator<MenuItem> it=menuItems.iterator();
        while(it.hasNext())
        {
            MenuItem aux=it.next();
            if (aux instanceof CompositeProduct)
            {
                CompositeProduct aux2= (CompositeProduct) aux;
                if (aux2.getBaseProducts().contains(menuItem))
                {
                    listToDel.add(aux2);
                }
            }
        }
        for(MenuItem i:listToDel)
        { deleteMenuItem(i); }
        if (menuItem!=null)
        { this.menuItems.remove(menuItem); }
    }
    public int getSize()
    {
        int counter=0;
        for(Map.Entry<Order,ArrayList<MenuItem>> entry:hashMap.entrySet())
        {
            if (entry.getKey()!=null)
            {
                for(MenuItem i:entry.getValue())
                {
                    if (i!=null)
                    {
                        counter++;
                    }
                }

            }
        }
        return 2*counter;
    }
    public String[] getOrderIDs()
    {
        int counter=this.getSize();
        String[] orderIDs=new String[counter];
        int k=0;
        for(Map.Entry<Order,ArrayList<MenuItem>> entry:hashMap.entrySet())
        {
            orderIDs[k++]=Integer.toString(entry.getKey().getID());
        }
        for(int i=0;i<orderIDs.length;i++)
        {
            if (orderIDs[i]==null)
            {
                orderIDs[i]=orderIDs[i-1];
                break;
            }
        }
        return orderIDs;
    }
    public String[] getOrderDates()
    {
        int counter=this.getSize();
        String[] orderDates=new String[counter];
        int k=0;
        for(Map.Entry<Order,ArrayList<MenuItem>> entry:hashMap.entrySet())
        {
            orderDates[k++]=entry.getKey().getDate();
        }
        for(int i=0;i<orderDates.length;i++)
        {
            if (orderDates[i]==null)
            {
                orderDates[i]=orderDates[i-1];
            }
        }
        return orderDates;
    }
    public String[] geOrderTableIDs()
    {
        int counter=this.getSize();
        String[] orderTableIDs=new String[counter];
        int k=0;
        for(Map.Entry<Order,ArrayList<MenuItem>> entry:hashMap.entrySet())
        {
            orderTableIDs[k++]=Integer.toString(entry.getKey().getTableNum());
        }
        for(int i=0;i<orderTableIDs.length;i++)
        {
            if (orderTableIDs[i]==null)
            {
                orderTableIDs[i]=orderTableIDs[i-1];
            }
        }
        return orderTableIDs;
    }
    public String[] getOrdersNames()
    {
        int counter=this.getSize();
        String[] orderProdsNames=new String[counter];
        int k=0;
        for(Map.Entry<Order,ArrayList<MenuItem>> entry:hashMap.entrySet())
        {
            for(MenuItem i:entry.getValue())
            {
               orderProdsNames[k++]=i.getName();
            }
        }
        return orderProdsNames;
    }
    public String[] getOrdersPrices()
    {
        int counter=this.getSize();
        String[] orderProdsPrices=new String[counter];
        int k=0;
        for(Map.Entry<Order,ArrayList<MenuItem>> entry:hashMap.entrySet())
        {
            for(MenuItem i:entry.getValue())
            {
                orderProdsPrices[k++]=Double.toString(i.computePrice());
            }
        }
        return orderProdsPrices;
    }
    public String[] getProductNamesFromOrders(Order order)
    {
        assert(order!=null):"Order cannot be null";
        ArrayList<MenuItem> products=hashMap.get(order);
        int length=products.size();
        int k=0;
       String[] productNames=new String[length];
       for(MenuItem i:products)
       {
           productNames[k++]=i.getName();
       }
       return productNames;
    }
    public Double[] getProductPricesFromOrders(Order order)
    {
        assert(order!=null):"Order cannot be null";
        ArrayList<MenuItem> products=hashMap.get(order);
        int length=products.size();
        int k=0;
        Double[] productPrices=new Double[length];
        for(MenuItem i:products)
        {
            productPrices[k++]=i.computePrice();
        }
        return productPrices;
    }

    /**
     *
     * @param order parametru de tip Order.Comanda ce va fi folosita ca si cheie pentru hashMap-ul din restaurant.
     * @param items parametru ArrayList de tipul MenuItem
     */
    @Override
    public void createOrder(Order order,ArrayList<MenuItem> items) {
        assert(order!=null && items!=null):"Order and items cannot be null";
        hashMap.put(order,items);
    }

    /**
     *
     * @param order parametru de tipul Order, caruia i se va calcula pretul total al comenzii bazat pe lista de produse.
     * @return Double pretul comenzii
     */
    @Override
    public Double computePriceForOrder(Order order) {
        assert(order!=null):"order cannot be null";
        ArrayList<MenuItem> orderItems=getHashMap().get(order);
        Double price=0.;
        for(MenuItem i:orderItems)
        {
            price+=i.computePrice();
        }
        return price;
    }

    /**
     *
     * @param nrBill reprezinta numarul chitantei ce trebuie generata sub forma de fisier .txt
     * @param ID  reprezinta numarul comenzii
     * @param date reprezinta data la care a fost efectuata comanda
     * @param tableNum reprezinta numarul mesei
     * @param productNames reprezinta numele produselor comandate de catre clienti
     * @param productPrices reprezinta preturile produselor comandate de catre clienti
     * @param totalPrice reprezinta pretul total al comenzii
     */
    @Override
    public void generateBill(int nrBill,int ID,String date,int tableNum,String[] productNames,Double[] productPrices,Double totalPrice) {
        assert(nrBill!=0 && ID!=0 && date!=null && tableNum!=0 && productNames!=null && productPrices!=null && totalPrice!=0):"nrBill cannot be 0, ID cannot be 0, " +
                "date cannot be null, tableNUm cannot be 0, productNames cannot be null," +
                " productPrices cannot be null , totalPrice cannot be 0";
        try {
            FileWriterClass fileWriter=new FileWriterClass(nrBill,ID,date,tableNum,productNames,productPrices,totalPrice);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public String sendOrderToChef(Order order)
    {
        assert(order!=null):"order cannot be null";
        String orderToSend="";
        ArrayList<MenuItem> orderItems=this.hashMap.get(order);
        for(MenuItem i: orderItems)
        {
            if (i instanceof CompositeProduct)
            { orderToSend+=i.getName()+" "; }
        }
        return orderToSend;
    }
    public void displayOrder(Order order)
    {
        assert(order!=null):"Order cannot be null";
        String orderProds=this.sendOrderToChef(order);
        setChanged();
        notifyObservers(orderProds);
    }
}
