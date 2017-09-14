/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pets;

/**
 *
 * @author Professor Wergeles
 */
public abstract class Pet {
    
    private static int numberOfPets = 0;
    
    private String name;
    private Integer age;
    private String type;
    private Gender gender;
    
    
    public Pet() {
        numberOfPets++;
    }
    
    public Pet(String type, Gender gender, String name, int age) {
        this();
        this.type = type;
        this.gender = gender;
        this.name = name;
        this.age = age;
    }
    
    public static int getNumberOfPets() {
        return numberOfPets;
    }
    
    public abstract int getNumberOfLegs(); 
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getType() {
        return type;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public int getAge(){
        return age;
    }
    
    public void setGender(Gender gender){
        this.gender = gender;
    }
    
    public Gender getGender(){
        return gender;
    }
    
    public int birthday() {
        age++;
        return age;
    }
    
    @Override
    public String toString() {
        return String.format("Type: %s, Name: %s, Age: %d, Gender: " + gender, type, name, age); 
    }
   
    public abstract boolean hasHair(); 
    
    public abstract boolean canFly(); 
    
    public abstract boolean canSwim(); 
        
}