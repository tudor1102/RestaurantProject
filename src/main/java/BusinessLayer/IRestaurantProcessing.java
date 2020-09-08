package BusinessLayer;

import java.util.ArrayList;

public interface IRestaurantProcessing {
    /**
     * @pre menuItem!=null
     * @post menuItem este adaugat la ArrayList de tipul MenuItem, lista responsabila de produse.
     * @param menuItem este un parametru de tipul MenuItem ce va fi adaugat la lista responsabila de produse.
     */
    public void addMenuItem(MenuItem menuItem);
    /**
     * @pre menuItem!=null
     * @post menuItem trimis ca parametru va fi sters.
     * @param menuItem parametru de tip menuItem care va fi cautat in lista de produse si va fi sters.
     */
    public void deleteCompProdItem(MenuItem menuItem);

    /**
     * @pre menuItem!=null
     * @post se va verifica daca menuItemul trimis ca si parametru a fost sters din lista de produse din restaurant.
     * @param menuItem parametru de tip menuItem care va fi cautat in lista de produse si va fi sters.
     */
    public void deleteMenuItem(MenuItem menuItem);

    /**
     * @pre order!=null  items!=null
     *  @post se va verifica daca comanda a fost adaugata.
     * @param order parametru de tip Order.Comanda ce va fi folosita ca si cheie pentru hashMap-ul din restaurant.
     * @param items parametru ArrayList de tipul MenuItem
     */
    public void createOrder(Order order,ArrayList<MenuItem> items);
    /**
     * @pre order!=null
     * @post pretul total al comenzii trebuie sa fie mai mare decat 0
     * @param order parametru de tipul Order, caruia i se va calcula pretul total al comenzii bazat pe lista de produse.
     * @return Double - returneaza pretul total al comenzii
     */
    public Double computePriceForOrder(Order order);

    /**
     * @pre nrBill!=0  ID!=0  data!=null  tableNum!=0  productNames!=0  price!=null  totalPrice!=0
     * @post se va verifica continutul fisierului billNumarChitanta.txt, astfel incat sa coincida cu parametrii trimisi
     * @param nrBill reprezinta numarul chitantei ce trebuie generata sub forma de fisier .txt
     * @param ID  reprezinta numarul comenzii
     * @param date reprezinta data la care a fost efectuata comanda
     * @param tableNum reprezinta numarul mesei
     * @param productNames reprezinta numele produselor comandate de catre clienti
     * @param prices reprezinta preturile produselor comandate de catre clienti
     * @param totalPrice reprezinta pretul total al comenzii
     */
    public void generateBill(int nrBill,int ID,String date,int tableNum,String[] productNames,Double[] prices,Double totalPrice);
}
