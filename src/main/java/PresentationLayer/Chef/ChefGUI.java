package PresentationLayer.Chef;

import BusinessLayer.Restaurant;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class ChefGUI extends JFrame  implements Observer{
   private Restaurant restaurant;
    private JTextArea foodOrder=new JTextArea("");
    private JLabel title=new JLabel("OPERARE SUB MODUL BUCATAR");
    private JLabel foodToken=new JLabel("FOOD TO PREPARE");
    public ChefGUI(Restaurant restaurant)
    {
        this.restaurant=restaurant;
        JFrame frame=new JFrame();
        frame.setLocation(700,200);
        JPanel panel=new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel.setLayout(new GridLayout(12,12,10,10));
        panel.add(title);
        panel.add(foodToken);
        panel.add(foodOrder);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }


    @Override
    public void update(Observable o, Object arg) {
        this.foodOrder.setText((String)arg);
    }
}

