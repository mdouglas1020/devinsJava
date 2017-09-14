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
public class Snake extends Pet {
 
    private String genus;
    private String typeOfSnake; 
    private boolean isHungry;
    private boolean isHappy = false;  
    private boolean canSwim;
            
    
    public Snake(Gender gender, String name, int age, String typeOfSnake){
        super("Snake", gender, name, age); 
        this.typeOfSnake = typeOfSnake; 
    }
    
    public String getGenus(){
        return genus; 
    }
    
    public void setGenus(String genus){
        this.genus = genus; 
    }
    
    public boolean getIsHungry(){
        return isHungry; 
    }
    
    public void setIsHungry(boolean isHungry){
        this.isHungry = isHungry; 
    }
    
    public String getTypeOfSnake(){
        return typeOfSnake; 
    }
    
    public void setTypeOfSnake(String typeOfSnake){
        this.typeOfSnake = typeOfSnake; 
    }
    
    public void feedSnake(){
        isHungry = false; 
        isHappy = true; 
    }
    
    @Override
    public String toString() {
       String info = super.toString();
        
       String updatedInfo =  String.format("%s, Type: %s, Genus: %s, isHappy: %s", info, typeOfSnake, genus, isHappy);
       
       return updatedInfo;
    }

    @Override
    public int getNumberOfLegs() {
        return 0; 
    }

    @Override
    public boolean hasHair() {
        return false; 
    }

    @Override
    public boolean canFly() {
        return false; 
    }
    
    public void setCanSwim(boolean canSwim){
        this.canSwim = canSwim; 
    }

    @Override
    public boolean canSwim() {
        return canSwim; 
    }
}