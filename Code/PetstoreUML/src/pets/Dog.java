/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pets;

import java.time.LocalDateTime;

/**
 *
 * @author Professor Wergeles
 */
public class Dog extends Pet implements LicensedPet, VaccinatedPet, TrainedDog {
    
    public static final String GENUS = "canis";
    
    private String typeOfDog; 
    private Boolean isHappy = false;
    private Boolean isSitting = false;
    private LocalDateTime whenLicensed;
    private String dogFood; 
    private int numberOfLegs;
    private boolean hasHair;
    private boolean canSwim;
    
    
    public Dog(Gender gender, String name, int age) {
        super("Dog", gender, name, age);
        dogFood = null; 
    }
    
    public void setTypeOfDog(String typeOfDog){
        this.typeOfDog = typeOfDog; 
    }
    
    public String getTypeOfDog(){
        return typeOfDog; 
    }
    
    public void petDog() {
        isHappy = true;
    }
    
    public void praiseDog() {
        isHappy = true;
    }
    
    public void yellAtDog() {
        isHappy = false;
    }
    
    public void kickDog(){
        isHappy = false; 
    }
    
    public void feedDog(String dogFood){
        this.dogFood = dogFood; 
        isHappy = true; 
    }
    
    public Boolean getIsHappy() {
        return isHappy;
    }
    
    public String getIsHappyAsString() {
        if (isHappy) {
            return "happy";
        } else {
            return "sad";
        }
    }
    
    @Override
    public String[] getCoreVacs() {
        
        String[] coreVaccines = {
            "Rabies 1-year",
            "Rabies 3-year",
            "Distemper",
            "Parvovirus",
            "Adenovirus"
        };
        
        return coreVaccines;
    }
    
    @Override
    public String[] getNoncoreVacs() {
        
        String[] nonCoreVaccines = {
            "Parainfluenza",
            "Bordetella bronchiseptica",
            "Lyme disease",
            "Leptospirosis",
            "Canine influenza"
        };
        
        return nonCoreVaccines;
    }

    @Override
    public Boolean isLicensed() {
        return whenLicensed != null;
    }

    @Override
    public void assignLicense() {
        whenLicensed = LocalDateTime.now();
    }

    @Override
    public LocalDateTime whenLicensed() {
        return whenLicensed;
    }

    @Override
    public void sit() {
        isSitting = true;
    }
    
    @Override
    public void unsit() {
        isSitting = false;
    }

    @Override
    public String speak() {
        return "Yawyahwer";
    }

    @Override
    public String bark(int numBarks) {
       String barks = "";
       for (int i = 0; i < numBarks; i++) {
           barks += "bark!";
       }
       
       return barks;
    }
    
    @Override
    public String toString() {
        String info = super.toString();
        
       String updatedInfo =  String.format("%s, isHappy: %s", info, isHappy);
       
       if (whenLicensed != null) {
           updatedInfo +=  ", whenLicensed: " + whenLicensed;
       }
       
       return updatedInfo;
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