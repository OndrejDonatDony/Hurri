/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hurricanemain.apps;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ondre
 */
public class HurriWrite {
    
    
    public static void WriteAllHurri(ArrayList<Hurri> hurriData,String filename) throws IOException{
        ArrayList<Hurri> sortedList = (ArrayList<Hurri>) hurriData.clone();
        sortedList.sort(Hurri.byName);
        FileWriter writer = null;        
        try{
            writer = new FileWriter(filename);
            for(Hurri h : sortedList){
                writer.write(h+"\n");
            }
        
        }finally{
            if(writer != null){
                writer.close();
            }
        }
        
    }
}
