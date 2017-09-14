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
public class Cat extends Pet implements LicensedPet, VaccinatedPet {
     
    public final static String GENUS = "Felis";
    
    private String typeOfCat; 
    private int numberOfLegs; 
    private boolean hasHair; 
    
    private LocalDateTime whenLicensed;
    
    private Boolean isHappy = false;
    private Boolean isPurring = false;
    private String catFood; 
    private Boolean declawed; 
    
    
    public Cat(Gender gender, String name, int age) {
        super("Cat", gender, name, age);
        catFood = null; 
        declawed = false; 
    }
    
    public void setTypeOfCat(String typeOfCat){
        this.typeOfCat = typeOfCat; 
    }
    
    public String getTypeOfCat(){
        return typeOfCat; 
    }

    @Override
    public String[] getCoreVacs() {    
        
        String[] coreVaccines = {
            "Rabies",
            "Feline Distemper",
            "Feline Herpesvirus",
            "Calicivirus"
        };
        
        return coreVaccines;   
    }

    @Override
    public String[] getNoncoreVacs() {
        
        String[] nonCoreVaccines = {
            "Feline Leukemia Virus",
            "Bordetella"
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
    public String toString() {
       String info = super.toString();
       
       if (whenLicensed != null) {
           info +=  ", whenLicensed: " + whenLicensed;
       }
       
       return info;
    }
    
    public void petCat() {
        isHappy = true;
    }
    
    public void praiseCat() {
        isHappy = true;
    }
    
    public void yellAtCat() {
        isHappy = false;
    }
    
    public void kickCat(){
        isHappy = false; 
    }
    
    public void feedCat(String catFood){
        this.catFood = catFood; 
        isHappy = true; 
    }
    
    public Boolean getIsHappy() {
        return isHappy;
    } 
    
    public void declawCat(Boolean declawed){
        this.declawed = declawed; 
        isHappy = false; 
    }
    
    public String meow(int numMeows){
        String meows = ""; 
        for(int i = 0; i < numMeows; i++){
            meows += "meow!\n"; 
        }
        return meows; 
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

    @Override
    public boolean canSwim() {
        return false; 
    } 
}