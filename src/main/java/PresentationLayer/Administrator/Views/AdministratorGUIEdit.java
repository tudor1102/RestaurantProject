package PresentationLayer.Administrator.Views;

import BusinessLayer.Restaurant;
import PresentationLayer.Administrator.Controllers.AdminEditController;

import javax.swing.*;
import java.awt.*;

public class AdministratorGUIEdit extends JFrame {
    Restaurant restaurant;
    AdminEditController c=new AdminEditController(this);
    private JButton editBaseProductButton=new JButton("Edit base product");
    private JButton editAddBaseProductButton=new JButton("Add base product");
    private JButton editRemoveBaseProductButton=new JButton("Remove base product");
    private JButton addCompositeProductButton=new JButton("Add composite product");
    private JButton removeCompositeProductButton=new JButton("Remove composite product");
    private JLabel labelEditComp=new JLabel("EDIT COMPOSITE PRODUCT");
    private JButton checkForCompButton=new JButton("Check for composite product");
    private JButton checkForBaseProd=new JButton("Check for base product");

    JLabel title=new JLabel("MENIU PENTRU ADMINISTRAREA RESTAURANTULUI(EDITARE)");
    JLabel labelEditProdName=new JLabel("Edit base product name: ");
    JLabel labelCompProdNameCheck=new JLabel("INSERT COMPOSITE PRODUCT-CHECK FOR EXISTENCE-EDIT");
    JLabel labelEditProdPrice=new JLabel("Edit base product price: ");
    JLabel labelSearchForBaseProduct=new JLabel("Base product for edit: ");

    JTextField fieldBaseProdNameForSearch=new JTextField("");
    JTextField fieldEditBaseProdName=new JTextField("");
    JTextField fieldEditBaseProdPrice=new JTextField("");
    JTextField fieldEditCompProdName=new JTextField("");
    JTextField fieldEditRemoveBaseProduct=new JTextField("");
    JTextField fieldAddCompositeProduct=new JTextField("");
    JTextField fieldRemoveCompositeProduct=new JTextField("");
    JTextField fieldEditEnterCompName=new JTextField("");
    JTextField fieldAddBaseProdName=new JTextField("");

    public AdministratorGUIEdit(Restaurant restaurant)
    {
        JFrame frame=new JFrame();
        this.restaurant=restaurant;
        JPanel panel=new JPanel();
        frame.setLocation(600,200);
        frame.setSize(500,700);

        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel.setLayout(new GridLayout(24,24,2,2));
        panel.add(title);
        panel.add(labelSearchForBaseProduct);
        panel.add(fieldBaseProdNameForSearch);
        panel.add(checkForBaseProd);
        panel.add(labelEditProdName);
        panel.add(fieldEditBaseProdName);
        panel.add(labelEditProdPrice);
        panel.add(fieldEditBaseProdPrice);
        panel.add(editBaseProductButton);
        panel.add(labelCompProdNameCheck);
        panel.add(labelEditComp);
        panel.add(fieldEditEnterCompName);
        panel.add(checkForCompButton);
        panel.add(fieldAddBaseProdName);
        panel.add(editAddBaseProductButton);
        panel.add(fieldEditRemoveBaseProduct);
        panel.add(editRemoveBaseProductButton);
        panel.add(fieldAddCompositeProduct);
        panel.add(addCompositeProductButton);
        panel.add(fieldRemoveCompositeProduct);
        panel.add(removeCompositeProductButton);

        checkForBaseProd.addActionListener(c);
        checkForCompButton.addActionListener(c);
        editBaseProductButton.addActionListener(c);
        editAddBaseProductButton.addActionListener(c);
        editRemoveBaseProductButton.addActionListener(c);
        addCompositeProductButton.addActionListener(c);
        removeCompositeProductButton.addActionListener(c);

        frame.add(panel);
        frame.pack();;
        frame.setVisible(true);
    }
    public JButton getCheckForBaseProd()
    {
        return this.checkForBaseProd;
    }
    public JTextField getFieldBaseProdNameForSearch()
    {
        return this.fieldBaseProdNameForSearch;
    }
    public JButton getEditBaseProductButton()
    {
        return this.editBaseProductButton;
    }
    public JButton getEditAddBaseProductButton()
    {
        return this.editAddBaseProductButton;
    }
    public JButton getEditRemoveBaseProductButton()
    {
        return this.editRemoveBaseProductButton;
    }
    public JButton getAddCompositeProductButton()
    {
        return this.addCompositeProductButton;
    }
    public JButton getRemoveCompositeProductButton()
    {
        return this.removeCompositeProductButton;
    }
    public JButton getCheckForCompButton()
    {
        return this.checkForCompButton;
    }
    public JTextField getFieldAddBaseProdName()
    {
        return this.fieldAddBaseProdName;
    }
    public JTextField getFieldEditBaseProdName()
    {
        return this.fieldEditBaseProdName;
    }
    public JTextField getFieldEditBaseProdPrice()
    {
        return this.fieldEditBaseProdPrice;
    }
    public JTextField getFieldEditCompProdName()
    {
        return this.fieldEditCompProdName;
    }
    public JTextField getFieldEditRemoveBaseProduct()
    {
        return this.fieldEditRemoveBaseProduct;
    }
    public JTextField getFieldAddCompositeProduct()
    {
        return this.fieldAddCompositeProduct;
    }
    public JTextField getFieldRemoveCompositeProduct()
    {
        return this.fieldRemoveCompositeProduct;
    }
    public JTextField getFieldEditEnterCompName()
    {
        return this.fieldEditEnterCompName;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
}
