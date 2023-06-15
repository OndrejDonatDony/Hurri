/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hurricanemain.apps;


import java.util.ArrayList;

/**
 *
 * @author ondre
 */



public class HurriUtil {

    public static Hurri GetHurriByName(ArrayList<Hurri> hurriData, String name) throws InputException  {
        double speedInKm = 0;
        
        for (Hurri i : hurriData) {
            if (i.getName().equals(name)) {
                return i;              
            }
        }       
       throw new InputException("spatne zadane jmeno");         
    }
  
}