/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hurricanemain.apps;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ondre
 */
public class BinaryFileWriter {
    public static void writeDataToFile(String fileName, ArrayList<Hurri> hurriData){
       
      
        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(fileName))) {
           
          hurriData.forEach((i)->{
              try {
                  outputStream.writeInt(i.getYear());
              } catch (IOException ex) {
                  Logger.getLogger(BinaryFileWriter.class.getName()).log(Level.SEVERE, null, ex);
              }
              try {
                  outputStream.writeUTF(i.getName());
              } catch (IOException ex) {
                  Logger.getLogger(BinaryFileWriter.class.getName()).log(Level.SEVERE, null, ex);
              }
            });
            
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error while saving data: " + e.getMessage());
        }
    }
}
