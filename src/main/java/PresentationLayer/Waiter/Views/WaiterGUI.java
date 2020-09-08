package PresentationLayer.Waiter.Views;

import BusinessLayer.Restaurant;
import PresentationLayer.Waiter.Controllers.WaiterGUIController;

import javax.swing.*;
import java.awt.*;

public class WaiterGUI extends JFrame {
   private Restaurant restaurant;
    private  WaiterGUIController controller = new WaiterGUIController(this);
    private JLabel title = new JLabel("OPERARE SUB MODUL CHELNER");
    private  JLabel newOrder = new JLabel("CREATE NEW ORDER");
    private  JLabel totalPrice = new JLabel("COMPUTE TOTAL PRICE");
    private JLabel createBill = new JLabel("GENERATE BILL");
    private  JLabel Product = new JLabel("PRODUCT");
    private JLabel Product1 = new JLabel("PRODUCT");
    private JLabel orderID = new JLabel("Insert order ID");
    private JLabel orderDate = new JLabel("Insert date ");
    private  JLabel tableID = new JLabel("Insert table number");
    private JLabel sendOrderToChef=new JLabel("Finish order and send to chef");

    private JTextField fieldCompositeProduct = new JTextField("");
    private JTextField fieldCompositeProduct1 = new JTextField("");
    private JTextField fieldOrderID = new JTextField("");
    private JTextField fieldOrderDate = new JTextField("");
    private JTextField fieldTableID = new JTextField("");
    private  JTextField fieldTotalPrice = new JTextField("");


    private JButton newOrderB = new JButton("CREATE NEW ORDER");
    private JButton totalPriceB = new JButton("COMPUTE TOTAL PRICE");
    private  JButton createBillB = new JButton("GENERATE BILL");
    private JButton addOrderToRestaurantB = new JButton("ADD ORDER TO RESTAURANT");
    private JButton addProductB = new JButton("ADD PRODUCT TO ORDER");
    private JButton showOrders=new JButton("SHOW ORDERS");
    private JButton finishOrderButton=new JButton("Finish order and send to chef");

    public WaiterGUI(Restaurant restaurant) {
        this.restaurant = restaurant;
        JFrame frame = new JFrame();
        frame.setLocation(700, 200);
        JPanel panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(24, 24, 10, 10));


        panel.add(title);
        panel.add(newOrder);
        panel.add(orderID);
        panel.add(fieldOrderID);
        panel.add(orderDate);
        panel.add(fieldOrderDate);
        panel.add(tableID);
        panel.add(fieldTableID);
        panel.add(Product1);
        panel.add(fieldCompositeProduct1);
        panel.add(newOrderB);
        panel.add(Product);
        panel.add(fieldCompositeProduct);
        panel.add(addProductB);
        panel.add(totalPrice);
        panel.add(fieldTotalPrice);
        panel.add(totalPriceB);
        panel.add(createBill);
        panel.add(createBillB);
        panel.add(showOrders);
        panel.add(sendOrderToChef);
        panel.add(finishOrderButton);

        newOrderB.addActionListener(controller);
        addProductB.addActionListener(controller);
        addOrderToRestaurantB.addActionListener(controller);
        totalPriceB.addActionListener(controller);
        createBillB.addActionListener(controller);
        showOrders.addActionListener(controller);
        finishOrderButton.addActionListener(controller);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public JButton getShowOrders(){return this.showOrders;}

    public JButton getNewOrderB() {
        return this.newOrderB;
    }

    public JButton getCreateBillB() {
        return this.createBillB;
    }

    public JButton getAddProductB() {
        return this.addProductB;
    }

    public JButton getTotalPriceB() {
        return this.totalPriceB;
    }
    public JButton getFinishOrderButton(){return this.finishOrderButton;}

    public JTextField getFieldCompositeProduct(){return this.fieldCompositeProduct;}
    public JTextField getFieldCompositeProduct1(){return this.fieldCompositeProduct1;}
    public JTextField getFieldOrderID(){return this.fieldOrderID;}
    public JTextField getFieldOrderDate(){return this.fieldOrderDate;}
    public JTextField getFieldTableID(){return this.fieldTableID;}
    public JTextField getFieldTotalPrice(){ return this.fieldTotalPrice;}
}
