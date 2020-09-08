package PresentationLayer.Administrator.Controllers;

import BusinessLayer.CompositeProduct;
import BusinessLayer.MenuItem;
import PresentationLayer.Administrator.Views.AdministratorGUIEdit;

import javax.swing.*;
import javax.xml.namespace.QName;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminEditController implements ActionListener {
    private AdministratorGUIEdit gui;
    public AdminEditController(AdministratorGUIEdit gui)
    {
        this.gui=gui;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source==gui.getCheckForBaseProd())
        {
            String nameForSearch=gui.getFieldBaseProdNameForSearch().getText();
            MenuItem baseProdForSearch=gui.getRestaurant().getBaseProductWithName(nameForSearch);
            if (baseProdForSearch!=null)
            {
                JFrame frame=new JFrame();
                frame.setLocation(500,500);
                JLabel label=new JLabel("BASE PRODUCT FOUND READY TO BE EDITED ");
                frame.add(label);
                frame.pack();
                frame.setVisible(true);
            }
        }
        if (source == gui.getEditBaseProductButton())
        {
           String nameForSearch=gui.getFieldBaseProdNameForSearch().getText();
           MenuItem baseProdForEdit=gui.getRestaurant().getBaseProductWithName(nameForSearch);
           String newName=gui.getFieldEditBaseProdName().getText();
           Double price=Double.parseDouble(gui.getFieldEditBaseProdPrice().getText());
           baseProdForEdit.setName(newName);
           baseProdForEdit.setPrice(price);
        }
        if (source==gui.getCheckForCompButton())
        {
            String nameForSearch=gui.getFieldEditEnterCompName().getText();
            MenuItem compProdForEdit=gui.getRestaurant().getCompositeProductWithName(nameForSearch);
            if (compProdForEdit!=null)
            {
                JFrame frame=new JFrame();
                frame.setLocation(500,500);
                JLabel label=new JLabel("COMPOSITE PRODUCT FOUND READY TO BE EDITED ");
                frame.add(label);
                frame.pack();
                frame.setVisible(true);
            }
        }
        if (source==gui.getEditAddBaseProductButton())
        {
            String compNameToAdd=gui.getFieldEditEnterCompName().getText();
            MenuItem compToAdd=gui.getRestaurant().getCompositeProductWithName(compNameToAdd);
            String baseProdNameToAdd=gui.getFieldAddBaseProdName().getText();
            MenuItem baseProdToAdd=gui.getRestaurant().getBaseProductWithName(baseProdNameToAdd);
            compToAdd.getBaseProducts().add(baseProdToAdd);
            compToAdd.computePrice();
        }
        if (source==gui.getEditRemoveBaseProductButton())
        {
            String compNameToRemove=gui.getFieldEditEnterCompName().getText();
            MenuItem compToRemove=gui.getRestaurant().getCompositeProductWithName(compNameToRemove);
            String baseProdToRemoveName=gui.getFieldEditRemoveBaseProduct().getText();
            compToRemove.removeMenuItem(baseProdToRemoveName);
            compToRemove.computePrice();
        }
        if (source==gui.getAddCompositeProductButton())
        {
            String compNameToAdd=gui.getFieldEditEnterCompName().getText();
            MenuItem compToAdd=gui.getRestaurant().getCompositeProductWithName(compNameToAdd);
            String addCompName=gui.getFieldAddCompositeProduct().getText();
            MenuItem addComp=gui.getRestaurant().getCompositeProductWithName(addCompName);
            compToAdd.getBaseProducts().add(addComp);
            compToAdd.computePrice();
        }
        if (source==gui.getRemoveCompositeProductButton())
        {
            String compNameToRemove=gui.getFieldEditEnterCompName().getText();
            MenuItem compToRemove=gui.getRestaurant().getCompositeProductWithName(compNameToRemove);
            String compRemove=gui.getFieldRemoveCompositeProduct().getText();
            compToRemove.removeMenuItem(compRemove);
            compToRemove.computePrice();
        }
    }
}
