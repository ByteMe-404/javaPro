/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Building_Management_system.Model;
import java.util.ArrayList;
/**
 *
 * @author rian64bit
 */
public class Building {
    private String BuildingName ; 
    private ArrayList<Floor> floors; 
    private boolean hasLift ; 
    private boolean hasGenerator ;
    
    public Building() {}

    public Building(String name, boolean hasLift, boolean hasGenerator, ArrayList<Floor> floors) {
        this.BuildingName = name;
        this.hasLift = hasLift;
        this.hasGenerator = hasGenerator;
        this.floors = floors;
    }

    public String getName() { return BuildingName; }
    public void setName(String name) { this.BuildingName = name; }
    public boolean isHasLift() { return hasLift; }
    public void setHasLift(boolean hasLift) { this.hasLift = hasLift; }
    public boolean isHasGenerator() { return hasGenerator; }
    public void setHasGenerator(boolean hasGenerator) { this.hasGenerator = hasGenerator; }
    public ArrayList<Floor> getFloors() { return floors; }
    public void setFloors(ArrayList<Floor> floors) { this.floors = floors; }
}
