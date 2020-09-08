package PresentationLayer;
import BusinessLayer.Restaurant;
import DataLayer.RestaurantSerializator;
import PresentationLayer.Administrator.Views.AdminGUIActions;
import PresentationLayer.Chef.ChefGUI;
import PresentationLayer.Waiter.Views.WaiterGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AppGUI extends JFrame {
    private Restaurant restaurant;
    private String fileName;
    private AppGUIController controller1 =new AppGUIController(this);
    private RestaurantSerializator restaurantSerializator=new RestaurantSerializator(this);
    private JButton buttonAdmin=new JButton("ADMINISTRATOR");
    private JButton buttonWaiter=new JButton("CHELNER");
    private JButton buttonChef=new JButton("BUCATAR");
    private JButton saveRestaurantButton=new JButton("SAVE RESTAURANT DATA");
    private JButton loadRestaurantButton=new JButton("LOAD RESTAURANT DATA");
    private JLabel labelOptions=new JLabel("ALEGETI UNA DINTRE URMATOARELE OPTIUNI PENTRU A OPERA SUB MODUL ADMINISTRATOR, CHELNER SAU BUCATAR");
    private JLabel saveRestaurantData=new JLabel("Save restaurant data");
    private JLabel loadRestaurantData=new JLabel("Load restaurant data");

    public AppGUI(String fileName) throws IOException {
        this.fileName=fileName;
        this.restaurant=new Restaurant();
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(900,200);


        JPanel panel=new JPanel();
        panel.setSize(500,600);
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel.setLayout(new GridLayout(10,10,10,10));


        panel.add(this.labelOptions);
        panel.add(this.buttonAdmin);
        panel.add(this.buttonWaiter);
        panel.add(this.saveRestaurantData);
        panel.add(this.saveRestaurantButton);
        panel.add(this.loadRestaurantData);
        panel.add(this.loadRestaurantButton);

       this.buttonAdmin.addActionListener(this.controller1);

        this.buttonWaiter.addActionListener(this.controller1);

        this.buttonChef.addActionListener(this.controller1);

        this.saveRestaurantButton.addActionListener(this.controller1);

        this.loadRestaurantButton.addActionListener(this.controller1);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    public String getFileName(){return this.fileName;}
    public Restaurant getRestaurant()
    {
        return this.restaurant;
    }
    public JButton getButtonAdmin()
    {
        return this.buttonAdmin;
    }
    public JButton getButtonWaiter()
    {
        return this.buttonWaiter;
    }
    public JButton getButtonChef()
    {
        return this.buttonChef;
    }
    public JButton getSaveRestaurantButton()
    {
        return this.saveRestaurantButton;
    }
    public JButton getLoadRestaurantButton()
    {
        return this.loadRestaurantButton;
    }
    public RestaurantSerializator getRestaurantSerializator(){return this.restaurantSerializator;}


    public static void main(String[] args) throws IOException {
        AppGUI gui=new AppGUI(args[0]);
    }

    public static class AppGUIController implements ActionListener {
        AppGUI app;

        public AppGUIController(AppGUI app)
        {
            this.app=app;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            Object source=e.getSource();
            if (source==app.getButtonAdmin())
            {
                AdminGUIActions adminGUIActions=new AdminGUIActions(app.getRestaurant());
            }
            if (source==app.getButtonWaiter())
            {
                WaiterGUI waiterGUI=new WaiterGUI(app.getRestaurant());
            }
            if (source==app.getButtonChef())
            {
                ChefGUI chefGUI=new ChefGUI(app.getRestaurant());
            }
            if (source==app.getSaveRestaurantButton())
            {
                try {
                    app.getRestaurantSerializator().serialize();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (source==app.getLoadRestaurantButton())
            {
                try {
                    app.getRestaurantSerializator().deserialize();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
