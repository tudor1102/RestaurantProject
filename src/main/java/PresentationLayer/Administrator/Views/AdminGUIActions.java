package PresentationLayer.Administrator.Views;

import BusinessLayer.Restaurant;
import PresentationLayer.Administrator.Controllers.AdminActionsController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminGUIActions extends JFrame {
    private  Restaurant restaurant;
    private AdminActionsController controller=new AdminActionsController(this);
    private JLabel title=new JLabel("ALEGETI UNA DINTRE OPERATII");
    private JLabel create=new JLabel("CREATE");
    private JLabel edit=new JLabel("EDIT");
    private JLabel delete=new JLabel("DELETE");
    private JLabel seeProducts=new JLabel("CLICK TO SEE PRODUCTS");
    private JButton createB=new JButton("CREATE");
    private JButton editB=new JButton("EDIT");
    private JButton deleteB=new JButton("DELETE");
    private JButton seeProductsB=new JButton("SEE PRODUCTS");
        public AdminGUIActions(Restaurant restaurant)
        {
            this.restaurant=restaurant;
            JFrame frame=new JFrame();
            frame.setLocation(600,600);
            JPanel panel=new JPanel();
            frame.add(panel);

            panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            panel.setLayout(new GridLayout(10,10,2,2));

            panel.add(title);
            panel.add(create);
            panel.add(createB);
            panel.add(edit);
            panel.add(editB);
            panel.add(delete);
            panel.add(deleteB);
            panel.add(seeProducts);
            panel.add(seeProductsB);
            createB.addActionListener(controller);

            editB.addActionListener(controller);

            deleteB.addActionListener(controller);

            seeProductsB.addActionListener(controller);

            frame.pack();
            frame.setVisible(true);
        }
    public JButton getCreateB(){return this.createB;}
    public JButton getEditB(){return this.editB;}
    public JButton getDeleteB(){return this.deleteB;}

    public JButton getSeeProductsB() {
        return seeProductsB;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
}
