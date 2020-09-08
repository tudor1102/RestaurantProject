package DataLayer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterClass {
    public FileWriterClass(int numFile,int orderID,String date,int tableNum,String[] products,Double[] prices,Double totalPrice) throws IOException {
        String toWrite="";
        File file=new File("billNo"+numFile+".txt");
        FileWriter writer=new FileWriter(file);
       toWrite="Numarul comenzii: "+Integer.toString(orderID)+" "+"Data: "+" "+date+" "+"Numarul mesei: "+Integer.toString(tableNum)+"\n";
       writer.write(toWrite);
        for(int i=0;i<products.length;i++)
        {
            toWrite+="Produse "+products[i]+" "+"Pret "+Double.toString(prices[i])+"\n";
        }
        toWrite+="Pretul total "+Double.toString(totalPrice);
        writer.write(toWrite);
        writer.flush();
    }
}
