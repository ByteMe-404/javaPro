/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Building_Management_system.Model;

/**
 *
 * @author rian64bit
 */
public class Bill {
    private String month ; 
    private double rent ; 
    private double utility ; 
    private double water ;
    private boolean paid ;  
    
        public Bill() {}

    public Bill(String month, double rent, double water, double utility, boolean paid) {
        this.month = month;
        this.rent = rent;
        this.water = water;
        this.utility = utility;
        this.paid = paid;
    }

    public String getMonth() { return month; }
    public void setMonth(String month) { this.month = month; }
    public double getRent() { return rent; }
    public void setRent(double rent) { this.rent = rent; }
    public double getWater() { return water; }
    public void setWater(double water) { this.water = water; }
    public double getUtility() { return utility; }
    public void setUtility(double utility) { this.utility = utility; }
    public boolean isPaid() { return paid; }
    public void setPaid(boolean paid) { this.paid = paid; }
    
}
