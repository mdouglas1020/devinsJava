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
public class Bird extends Pet {
    
    private String genus;
    private String typeOfBird; 
    private int numberOfLegs;
    private boolean hasHair;
    private boolean canFly;
    
    
    public Bird(Gender gender, String name, int age){
        super("Bird", gender, name, age); 
    }
    
    public void setGenus(String genus){
        this.genus = genus; 
    }
    
    public String getGenus(){
        return genus; 
    }
    
    public void setTypeOfBird(String typeOfBird){
        this.typeOfBird = typeOfBird; 
    }
    
    public String getTypeOfBird(){
        return typeOfBird; 
    }
    
    public void setNumberOfLegs(int numberOfLegs){
        this.numberOfLegs = numberOfLegs; 
    }

    @Override
    public int getNumberOfLegs() {
        return numberOfLegs; 
    }
    
    public void setHasHair(boolean hasHair){
        this.hasHair = hasHair; 
    }

    @Override
    public boolean hasHair() {
        return hasHair; 
    }
    
    public void setCanFly(boolean canFly){
        this.canFly = canFly; 
    }

    @Override
    public boolean canFly() {
        return canFly; 
    }

    @Override
    public boolean canSwim() {
        return false; 
    } 
    
    @Override
    public String toString() {
       String info = super.toString();
        
       String updatedInfo =  String.format("%s, Type: %s, Genus: %s", info, typeOfBird, genus);
       
       return updatedInfo;
    }
}