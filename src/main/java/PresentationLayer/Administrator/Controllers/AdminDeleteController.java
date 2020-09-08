package PresentationLayer.Administrator.Controllers;

import BusinessLayer.MenuItem;
import PresentationLayer.Administrator.Views.AdministratorGUIDelete;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDeleteController implements ActionListener {
    private  AdministratorGUIDelete gui;
    public AdminDeleteController(AdministratorGUIDelete gui)
    {
        this.gui=gui;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source=e.getSource();

        if (source==gui.getDeleteProductButton())
        {
            String deleteCompProdName=gui.getFieldDeleteCompProd().getText();
            MenuItem toDelete=gui.getRestaurant().getMenuItemWithName(deleteCompProdName);
            if (toDelete!=null)
            gui.getRestaurant().deleteMenuItem(toDelete);
            else
            {
                JFrame frame=new JFrame();
                frame.setLocation(500,500);
                JLabel label=new JLabel("Product not found!Check again!");
                frame.add(label);
                frame.pack();
                frame.setVisible(true);
            }
        }
    }
}
