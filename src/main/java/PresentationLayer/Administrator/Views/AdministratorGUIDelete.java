package PresentationLayer.Administrator.Views;

import BusinessLayer.Restaurant;
import PresentationLayer.Administrator.Controllers.AdminDeleteController;

import javax.swing.*;
import java.awt.*;

public class AdministratorGUIDelete extends JFrame {
   private Restaurant restaurant;
    private AdminDeleteController c=new AdminDeleteController(this);
    private JLabel title=new JLabel("MENIU PENTRU ADMINISTRAREA RESTAURANTULUI(STERGERE)");
    private JTextField fieldDeleteCompProd=new JTextField("");
    private JButton deleteProductButton=new JButton("DELETE PRODUCT");
    public AdministratorGUIDelete(Restaurant restaurant)
    {
        this.restaurant=restaurant;
        JFrame frame=new JFrame();
        frame.setLocation(500,200);

        JPanel panel=new JPanel();
        panel.setSize(500,600);
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel.setLayout(new GridLayout(10,10,10,10));
        panel.add(title);
        panel.add(fieldDeleteCompProd);
        panel.add(deleteProductButton);

        deleteProductButton.addActionListener(c);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

    }

    public JTextField getFieldDeleteCompProd()
    {
        return this.fieldDeleteCompProd;
    }

    public JButton getDeleteProductButton()
    {
        return this.deleteProductButton;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
}
