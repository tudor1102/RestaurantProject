package PresentationLayer.Waiter.Controllers;

import BusinessLayer.MenuItem;
import BusinessLayer.Order;
import DataLayer.FileWriterClass;
import PresentationLayer.Chef.ChefGUI;
import PresentationLayer.Waiter.Views.WaiterGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class WaiterGUIController implements ActionListener {
     private  WaiterGUI gui;
    public WaiterGUIController(WaiterGUI waiterGUI)
    {
        this.gui=waiterGUI;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source=e.getSource();
        if (source==gui.getNewOrderB())
        {
            int ID=Integer.parseInt(gui.getFieldOrderID().getText());
            String date=gui.getFieldOrderDate().getText();
            int tableNum=Integer.parseInt(gui.getFieldTableID().getText());

            Order order=new Order(ID,date,tableNum);

            String productName=gui.getFieldCompositeProduct1().getText();
            MenuItem menuItem=gui.getRestaurant().getMenuItemWithName(productName);
            ArrayList<MenuItem> products=new ArrayList<MenuItem>();

            products.add(menuItem);
            gui.getRestaurant().createOrder(order,products);

        }
        if (source==gui.getAddProductB())
        {
            int ID=Integer.parseInt(gui.getFieldOrderID().getText());
            String date=gui.getFieldOrderDate().getText();
            int tableNum=Integer.parseInt(gui.getFieldTableID().getText());

            Order order=new Order(ID,date,tableNum);
            String productName=gui.getFieldCompositeProduct().getText();
            MenuItem toAdd=gui.getRestaurant().getMenuItemWithName(productName);
            ArrayList<MenuItem> orderItems=gui.getRestaurant().getHashMap().get(order);
            orderItems.add(toAdd);
            gui.getRestaurant().createOrder(order,orderItems);
        }
        if (source==gui.getTotalPriceB())
        {
            int ID=Integer.parseInt(gui.getFieldOrderID().getText());
            String date=gui.getFieldOrderDate().getText();
            int tableNum=Integer.parseInt(gui.getFieldTableID().getText());

            Order order=new Order(ID,date,tableNum);
            Double price=gui.getRestaurant().computePriceForOrder(order);
            gui.getFieldTotalPrice().setText(price.toString());
        }
        if (source==gui.getCreateBillB())
        {
            int ID=Integer.parseInt(gui.getFieldOrderID().getText());
            String date=gui.getFieldOrderDate().getText();
            int tableNum=Integer.parseInt(gui.getFieldTableID().getText());
            Order order=new Order(ID,date,tableNum);

            String[] productNames=gui.getRestaurant().getProductNamesFromOrders(order);
            Double[] productPrices=gui.getRestaurant().getProductPricesFromOrders(order);
            Double totalPrice=gui.getRestaurant().computePriceForOrder(order);
            gui.getRestaurant().generateBill(ID,ID,date,tableNum,productNames,productPrices,totalPrice);
        }
        if (source==gui.getShowOrders()) {

            JFrame frame = new JFrame();
            frame.setLocation(500, 500);
            String[] columnNames = {"ID", "Data", "Numarul mesei", "Produse", "Pret"};
            String[] productNames = gui.getRestaurant().getOrdersNames();
            String[] productPrices = gui.getRestaurant().getOrdersPrices();
            String[] orderIDs=gui.getRestaurant().getOrderIDs();
            String[] orderDates=gui.getRestaurant().getOrderDates();
            String[] orderTableIDs=gui.getRestaurant().geOrderTableIDs();
            String[][] data = new String[(productNames.length) + 1][5];
            int i = 1;
            while (i < productNames.length + 1){
                data[0][0]=columnNames[0];
                data[0][1]=columnNames[1];
                data[0][2]=columnNames[2];
                data[0][3]=columnNames[3];
                data[0][4]=columnNames[4];
                data[i][0]=orderIDs[i-1];
                data[i][1]=orderDates[i-1];
                data[i][2]=orderTableIDs[i-1];
                data[i][3]=productNames[i-1];
                data[i][4]=productPrices[i-1];
                i++;
            }
            JTable table=new JTable(data,columnNames);
           frame.add(table);
           frame.pack();
           frame.setVisible(true);

        }
        if (source==gui.getFinishOrderButton())
        {
            int ID=Integer.parseInt(gui.getFieldOrderID().getText());
            String date=gui.getFieldOrderDate().getText();
            int tableNum=Integer.parseInt(gui.getFieldTableID().getText());
            Order order=new Order(ID,date,tableNum);
            ChefGUI chefGUI=new ChefGUI(gui.getRestaurant());
            gui.getRestaurant().addObserver(chefGUI);
            gui.getRestaurant().displayOrder(order);
        }
    }
}
