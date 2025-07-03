/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Building_Management_system.Model;

/**
 *
 * @author rian64bit
 */
public class FamilyMember {
    private String name ; 
    private int age ; 
    private String profession ; 
    private String relation ; 
    
    public FamilyMember(){};
    
    public FamilyMember(String name , int age , String profess , String relation){
        this.name = name ; 
        this.age = age ; 
        this.profession = profess ; 
        this.relation = relation ; 
    }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRelation() { return relation; }
    public void setRelation(String relation) { this.relation = relation; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getProfession() { return profession; }
    public void setProfession(String profession) { this.profession = profession; }
}






