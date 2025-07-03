/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Building_Management_system.Model;
import java.util.ArrayList;
import java.time.LocalDate;
/**
 *
 * @author rian64bit
 */
public class Tenant extends Person {
    private String profession ;
    private Address address ;
    private ArrayList<Person> family ; 
    private Bill bill ;
    private boolean Parking ; 
    private LocalDate rentedsince ;
    
        public Tenant(String name, int age, String relation, int nid, String phone, Address address,
                  ArrayList<Person> familyMembers, boolean usesParking, Bill bills, LocalDate rentedSince) {
        super(name, age, relation, nid, phone);
        this.address = address;
        this.family = familyMembers;
        this.Parking = usesParking;
        this.bill = bills;
        this.rentedsince = rentedSince;
    }

        public String getProfession() { return profession; }
        public void setProfession(String profession) { this.profession = profession; }
        public Address getAddress() { return address; }
        public void setAddress(Address address) { this.address = address; }
        public ArrayList<Person> getFamily() { return family; }
        public void setFamily(ArrayList<Person> family) { this.family = family; }
        public Bill getBill() { return bill; }
        public void setBill(Bill bill) { this.bill = bill; }
        public boolean isParking() { return Parking; }
        public void setParking(boolean parking) { Parking = parking; }
        public LocalDate getRentedsince() { return rentedsince; }
        public void setRentedsince(LocalDate rentedsince) { this.rentedsince = rentedsince; 
    }        
}






