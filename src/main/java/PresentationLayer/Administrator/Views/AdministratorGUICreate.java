package PresentationLayer.Administrator.Views;
import BusinessLayer.Restaurant;
import PresentationLayer.Administrator.Controllers.AdminCreateController;

import javax.swing.*;
import java.awt.*;

public class AdministratorGUICreate extends JFrame {

        private Restaurant restaurant;
       private AdminCreateController c=new AdminCreateController(this);

        private JButton baseProdButton=new JButton("Create base product");
        private JButton compProdButton=new JButton("Create composite product");
        private JButton addBaseProdToCompButton=new JButton("Add base product to composite product");
        private JButton createMenuItemButton=new JButton("Create menu item");
        private JButton addCompositeProdToMenuItem=new JButton("Add composite product");

       private JLabel title=new JLabel("MENIU PENTRU ADMINISTRAREA RESTAURANTULUI(CREARE)");

       private JPanel menuItemPanel=new JPanel();




      private  JLabel labelBaseProdName=new JLabel("Base product name: ");
       private JLabel labelBaseProdName1=new JLabel("Base product name: ");
        private JLabel labelBaseProdPrice=new JLabel("Base product price: ");
        private JLabel labelCompProdName=new JLabel("Composite product name: ");
        private JLabel labelCompProdName1=new JLabel("Composite product name: ");
       private  JLabel labelMenuItemName=new JLabel("Menu item name: ");


       private JTextField fieldBaseProdName=new JTextField("");
    private JTextField fieldBaseProdPrice=new JTextField("");
    private  JTextField fieldCompProdName=new JTextField("");
    private  JTextField fieldCompProdName1=new JTextField("");
    private   JTextField fieldAddBaseProdName=new JTextField("");
    private   JTextField fieldMenuItemName=new JTextField("");


        public AdministratorGUICreate(Restaurant restaurant)
        {
            this.restaurant=restaurant;
            JFrame frame=new JFrame();
            frame.setLocation(700,200);
            frame.setSize(600,700);


            menuItemPanel.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
            menuItemPanel.setLayout(new GridLayout(18,18,2,2));

            menuItemPanel.add(title);
            menuItemPanel.add(labelBaseProdName);
            menuItemPanel.add(fieldBaseProdName);
            menuItemPanel.add(labelBaseProdPrice);
            menuItemPanel.add(fieldBaseProdPrice);
            menuItemPanel.add(baseProdButton);

             menuItemPanel.add(labelCompProdName);
            menuItemPanel.add(fieldCompProdName);
            menuItemPanel.add(labelBaseProdName1);
            menuItemPanel.add(fieldAddBaseProdName);
            menuItemPanel.add(addBaseProdToCompButton);
            menuItemPanel.add(compProdButton);


           menuItemPanel.add(labelMenuItemName);
            menuItemPanel.add(fieldMenuItemName);
            menuItemPanel.add(labelCompProdName1);
            menuItemPanel.add(fieldCompProdName1);
            menuItemPanel.add(addCompositeProdToMenuItem);
            menuItemPanel.add(createMenuItemButton);

            baseProdButton.addActionListener(this.c);
            addBaseProdToCompButton.addActionListener(this.c);
            compProdButton.addActionListener(this.c);
            addCompositeProdToMenuItem.addActionListener(this.c);
            createMenuItemButton.addActionListener(this.c);

            frame.add(menuItemPanel);
            frame.pack();
            frame.setVisible(true);
        }

    public JTextField getFieldBaseProdName()
    {
        return this.fieldBaseProdName;
    }
    public JTextField getFieldBaseProdPrice()
    {
        return this.fieldBaseProdPrice;
    }
    public JButton getBaseProdButton()
    {
        return this.baseProdButton;
    }
    public JTextField getFieldCompProdName()
    {
        return this.fieldCompProdName;
    }
    public JButton getCompProdButton()
    {
        return this.compProdButton;
    }

    public JTextField getFieldAddBaseProdName()
    {
        return this.fieldAddBaseProdName;
    }
    public JButton getAddBaseProdToCompButton()
    {
        return this.addBaseProdToCompButton;
    }
    public JTextField getFieldMenuItemName(){return this.fieldMenuItemName;}
    public JTextField getFieldCompProdName1(){return this.fieldCompProdName1;}
    public JButton getAddCompositeProdToMenuItem(){return this.addCompositeProdToMenuItem;}
    public JButton getCreateMenuItemButton(){return this.createMenuItemButton;}
    public Restaurant getRestaurant() {
        return restaurant;
    }
}
