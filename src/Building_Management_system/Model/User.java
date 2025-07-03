/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Building_Management_system.Model;

/**
 *
 * @author rian64bit
 */
public class User {
    private String username ;
    private String password ;
    
    public User(String username , String password){    
        this.username = username ; 
        this.password = password  ;
    }
    
    public String getPass(){
        return password;
    }
    
    public String getUser(){
        return username ; 
    }
    
    public void setUser(String user){
        this.username = user ; 
    }
    public void setPass(String pass){
        this.password = pass; 
    }
       
}
