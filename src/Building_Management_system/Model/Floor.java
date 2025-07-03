/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Building_Management_system.Model;
import java.util.ArrayList ;
/**
 *
 * @author rian64bit
 */
public class Floor {
    private int floorNumber ;
    ArrayList<Apartment> appartments ; 
     public Floor() {}

    public Floor(int floorNumber, ArrayList<Apartment> apartments) {
        this.floorNumber = floorNumber;
        this.appartments = apartments;
    }

    public int getFloorNumber() { return floorNumber; }
    public void setFloorNumber(int floorNumber) { this.floorNumber = floorNumber; }
    public ArrayList<Apartment> getApartments() { return appartments; }
    public void setApartments(ArrayList<Apartment> apartments) { this.appartments = apartments; 
    }
}
