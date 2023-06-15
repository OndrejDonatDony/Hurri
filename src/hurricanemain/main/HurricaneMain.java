/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hurricanemain.main;

import hurricanemain.apps.BinaryFileWriter;
import hurricanemain.apps.Hurri;
import hurricanemain.apps.HurriRead;
import hurricanemain.apps.HurriUtil;
import hurricanemain.apps.HurriWrite;
import hurricanemain.apps.InputException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ondre
 */

public class HurricaneMain {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args){
        String fileName = "hurriOutput.txt";
        String textFile = "data/txtDataHurri.txt";
      
       
       
        ArrayList<Hurri> hurriData = HurriRead.ReadFile1(textFile);
        if(hurriData == null){
            return;
        }
        Scanner sc = new Scanner(System.in); 
      
        Hurri hurikan = null;
        while(hurikan == null){

            System.out.println("zadej jmeno hurikanu");
            String name = sc.next();
            try {
             
                hurikan = HurriUtil.GetHurriByName(hurriData, name);
               System.out.println(hurikan.getSpeedKm()+" kategory: "+hurikan.getKategory());
            } catch (InputException ex) {
                System.out.println("spatny jmeno "+ex.getMessage());
            }
        }
        
        
        Collections.sort(hurriData);
        hurriData.forEach((i)->{
            System.out.println(i);
        });
        
        
        try {
            HurriWrite.WriteAllHurri(hurriData, fileName);
            //HurriWrite.WriteToFile(fileName, year);
            //HurriWrite.WriteToFile(fileName, month);
        } catch (IOException ex) {
            System.out.println("Chyba zapisu "+ ex.getMessage());
            
        }
        
        String fileName2 = "binary.bin";
        BinaryFileWriter.writeDataToFile(fileName2, hurriData);
        
    }
}
