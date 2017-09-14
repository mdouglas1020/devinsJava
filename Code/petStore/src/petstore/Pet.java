/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petstore;

import static petstore.Gender.*;

/**
 *
 * @author devincargill
 */
public class Pet {
    public String type;
    private String name;
    public int age;
    public Gender gender;
    
    //constructor
    public Pet() {
        
    }
    
    //can have multiple constructors as long as they're different
    public Pet(String type, String name, int age, Gender gender) {
        this.type = type;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    
    //Method for setting a private variable
    public void setName(String input) {
        this.name = input;
    }
    
    //Method for access a private variable
    public String getName() {
        return this.name;
    }
    
    public String getType(){
        return type;
    }
    
    public void birthday(){
        age++;
    }
    
    public int getAge(){
        return age;
    }
    
    public void dogBirthday(){
        age += 7;
    }
}
