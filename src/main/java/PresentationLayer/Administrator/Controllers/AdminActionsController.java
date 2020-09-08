package PresentationLayer.Administrator.Controllers;

import PresentationLayer.Administrator.Views.AdminGUIActions;
import PresentationLayer.Administrator.Views.AdministratorGUICreate;
import PresentationLayer.Administrator.Views.AdministratorGUIDelete;
import PresentationLayer.Administrator.Views.AdministratorGUIEdit;
import PresentationLayer.AppGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminActionsController implements ActionListener {
      private  AdminGUIActions adminGUIActions;
    public AdminActionsController(AdminGUIActions adminGUIActions)
    {
        this.adminGUIActions=adminGUIActions;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    Object source=e.getSource();
        if (source==adminGUIActions.getCreateB())
        {
            AdministratorGUICreate administratorGUICreate=new AdministratorGUICreate(adminGUIActions.getRestaurant());
        }
        if (source==adminGUIActions.getEditB())
        {
            AdministratorGUIEdit administratorGUIEdit=new AdministratorGUIEdit(adminGUIActions.getRestaurant());
        }
        if (source==adminGUIActions.getDeleteB())
        {
            AdministratorGUIDelete administratorGUIDelete=new AdministratorGUIDelete(adminGUIActions.getRestaurant());
        }
        if (source==adminGUIActions.getSeeProductsB())
        {
            JFrame frame=new JFrame();

            String[] baseProducts=adminGUIActions.getRestaurant().getProducts();
            Double[] prices=adminGUIActions.getRestaurant().getPrices();

            String[] columnNames={"Products","Product prices"};

            String[][] data=new String[adminGUIActions.getRestaurant().getNrOfProds()+1][2];

            int i=1;

            while(i<adminGUIActions.getRestaurant().getNrOfProds()+1)
            {
                data[0][0]=columnNames[0];
                data[0][1]=columnNames[1];
                data[i][0]=baseProducts[i-1];
                data[i][1]=prices[i-1].toString();
                i++;
            }

            JTable table=new JTable(data,columnNames);
            frame.setLocation(700,700);
            frame.add(table);

            frame.pack();

            frame.setVisible(true);

        }
    }
}
