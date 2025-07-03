/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Building_Management_system.Model;

/**
 *
 * @author rian64bit
 */
public class Person {
    private String name ; 
    private int age ; 
    private int nid ; 
    private String phone ;
    private String relation ; 
    
    public Person(){};
    
    public Person(String name , int age  , String relation , int nid , String phone){
        this.name = name ; 
        this.age = age ; 
        this.relation = relation ; 
        this.nid = nid ; 
        this.phone= phone ;
    }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRelation() { return relation; }
    public void setRelation(String relation) { this.relation = relation; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}






