package PresentationLayer.Administrator.Controllers;

import BusinessLayer.BaseProduct;
import BusinessLayer.CompositeProduct;
import BusinessLayer.MenuItem;
import PresentationLayer.Administrator.Views.AdministratorGUICreate;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminCreateController implements ActionListener {
        private MenuItem menuItem;
        private AdministratorGUICreate gui;

        public AdminCreateController(AdministratorGUICreate gui)
        {
                this.gui=gui;

        }

    @Override
    public void actionPerformed(ActionEvent e) {
            Object source=e.getSource();
            if (source==gui.getBaseProdButton())
            {
               String baseProdName=gui.getFieldBaseProdName().getText();
               Double price=Double.parseDouble(gui.getFieldBaseProdPrice().getText());
                MenuItem baseProduct= new BaseProduct(baseProdName,price);
                this.gui.getRestaurant().addBaseProduct(baseProduct);

            }

            if (source==gui.getCompProdButton())
            {
                String compProdName=gui.getFieldCompProdName().getText();
                MenuItem compositeProduct=new CompositeProduct(compProdName, (double) 0);
                this.gui.getRestaurant().getMenuItems().add(compositeProduct);
            }

            if (source==gui.getAddBaseProdToCompButton())
            {
                String baseProdName=gui.getFieldAddBaseProdName().getText();
                String compProdName=gui.getFieldCompProdName().getText();

                if (this.gui.getRestaurant().checkForBaseProduct(baseProdName))
                {
                   CompositeProduct p= this.gui.getRestaurant().getCompositeProductWithName(compProdName);
                    p.getBaseProducts().add(this.gui.getRestaurant().getBaseProductWithName(baseProdName));
                    p.computePrice();
                    //System.out.println("Price: "+p.computePrice());
                }
            }
            if (source==gui.getCreateMenuItemButton())
            {
                String MenuName=gui.getFieldMenuItemName().getText();
                MenuItem menuItem=new CompositeProduct(MenuName,(double)0);
                this.gui.getRestaurant().addMenuItem(menuItem);
            }
            if (source==gui.getAddCompositeProdToMenuItem())
            {
                String compProdName=gui.getFieldCompProdName1().getText();
                String menuItemName=gui.getFieldMenuItemName().getText();
                if (this.gui.getRestaurant().checkForMenuItemName(menuItemName))
                {
                    CompositeProduct p=this.gui.getRestaurant().getCompositeProductWithName(compProdName);
                    CompositeProduct menu=this.gui.getRestaurant().getCompositeProductWithName(menuItemName);
                    menu.getBaseProducts().add(p);
                    menu.computePrice();
                }
                //this.gui.getRestaurant().showMenus();
            }
    }
}
