package DataLayer;

import BusinessLayer.MenuItem;
import BusinessLayer.Restaurant;
import PresentationLayer.AppGUI;

import java.io.*;
import java.lang.reflect.Member;
import java.util.ArrayList;

public class RestaurantSerializator implements Serializable {
    private AppGUI appGUI;
    public RestaurantSerializator(AppGUI gui) throws IOException {
        this.appGUI=gui;
    }
    public void serialize() throws IOException {
        ArrayList<MenuItem> productList=appGUI.getRestaurant().getMenuItems();
        FileOutputStream file=new FileOutputStream(appGUI.getFileName());
        ObjectOutputStream out=new ObjectOutputStream(file);
        out.writeObject(productList);
        out.close();
        file.close();
    }
    public void deserialize() throws IOException, ClassNotFoundException {
        FileInputStream file=new FileInputStream(appGUI.getFileName());
        ObjectInputStream in=new ObjectInputStream(file);
        ArrayList<MenuItem> productsToLoadTo= appGUI.getRestaurant().getMenuItems();
        productsToLoadTo=(ArrayList<MenuItem>)in.readObject();
        appGUI.getRestaurant().setMenuItems(productsToLoadTo);
    }
}
