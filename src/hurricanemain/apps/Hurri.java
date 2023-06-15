/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hurricanemain.apps;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author ondre
 */
public class Hurri implements Comparable {
    public String name;
    public int year;
    public String month;
    public int pressure;
    public int speed;
    
    
    public Hurri(int year,String month, int pressure, int speed,String name){
        this.month = month;
        this.name = name;
        this.pressure = pressure;
        this.speed = speed;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public int getPressure() {
        return pressure;
    }

    public int getSpeed() {
        return speed;
    }
    public double getSpeedKm(){
        return (double)speed* 1.852;
    }
    public int getKategory(){
        double speedInKm = getSpeedKm();
            int category;
            if (speedInKm < 119.0) {
                category = 0;
            } else if (speedInKm < 154.0) {
                category = 1;
            } else if (speedInKm < 178.0) {
                category = 2;
            } else if (speedInKm < 209.0) {
                category = 3;
            } else if (speedInKm < 251.0) {
                category = 4;
           
            } else{
                category = 5;
            }
        return category;
    }
    @Override
    public int compareTo(Object o) {
        Hurri h = (Hurri)o;
        if(speed>h.speed){
            return 1;
        }else if(speed<h.speed){
            return -1;
        }else{
            return 0;
        }
    }
    
    @Override
    public String toString() {
        return "Hurri{" + "name=" + name + ", year=" + year + ", month=" + month + ", pressure=" + pressure + ", speed=" + speed + '}';
    }
    public static Comparator byName = (Comparator) (Object o1, Object o2) -> {
        Hurri h1 = (Hurri)o1;
        Hurri h2 = (Hurri)o2;
        return h1.name.compareTo(h2.name);
    };
    
}
