/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Building_Management_system.Model;

/**
 *
 * @author rian64bit
 */
public class Address {
    private String presentAddr ; 
    private String permanentAddr ; 
    
    public Address(String present , String perma){
        this.permanentAddr =perma;  
        this.presentAddr = present;
    }
    public String getPresentAddr(){
        return presentAddr; 
    }
    
    public String getPermanentAddr(){
        return permanentAddr; 
    }
    
    public void setPresentAddr(String present){
        this.presentAddr = present ;
    }
    
    public void setPermanentAddr(String perma){
        this.permanentAddr = perma ;
    }    
}










