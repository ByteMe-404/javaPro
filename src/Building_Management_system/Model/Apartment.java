/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Building_Management_system.Model;

/**
 *
 * @author rian64bit
 */
public class Apartment {
    private String appartmentId ; 
    private boolean isRented ; 
    private Tenant tenant ;
    
    public Apartment() {}

    public Apartment(String apartmentId) {
        this.appartmentId = apartmentId;
        this.isRented = false;
    }

    public String getApartmentId() { return appartmentId; }
    public void setApartmentId(String apartmentId) { this.appartmentId = apartmentId; }
    public boolean isRented() { return isRented; }
    public void setRented(boolean rented) { isRented = rented; }
    public Tenant getTenant() { return tenant; }
    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
        this.isRented = tenant != null;
    }
}
