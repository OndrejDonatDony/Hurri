/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hurricanemain.apps;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author ondre
 */
public class HurriRead {
    public static ArrayList<Hurri> ReadFile1(String textFile){
        ArrayList<Hurri> hurriList = new ArrayList<Hurri>();
        File text = new File(textFile);
        String[] txtSplitBy;
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(text))){
            while((line = reader.readLine())!=null){
                
                txtSplitBy = line.split(" ");
                
                int year = Integer.parseInt(txtSplitBy[0]);
                String month = txtSplitBy[1];
                int pressure = Integer.parseInt(txtSplitBy[2]);
                int speed = Integer.parseInt(txtSplitBy[3]);
                String name = txtSplitBy[4];
                Hurri hurriData = new Hurri(
                        year,
                        month,
                        pressure,
                        speed,
                        name    
                );
                hurriList.add(hurriData);
            }
       
        }catch(IOException e){
            System.out.println("File not found");
            e.printStackTrace();
            return null;
        }catch(NumberFormatException e){
            System.out.println("Numbers are in wrong format");
            e.printStackTrace();
            return null;
        }
        return hurriList;   
    }
}
