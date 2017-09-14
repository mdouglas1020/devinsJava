/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petstore;

//import static petstore.Gender.FEMALE;
//import static petstore.Gender.MALE;

import static petstore.Gender.*;

/**
 *
 * @author devincargill
 */
public class PetStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //how to call a new object
        Pet pet = new Pet();
        
        //pet.name = "Oreo";
        pet.setName("Oreo");
        pet.age = 3;
        pet.gender = MALE;
        pet.type = "CAT";
        
        Pet pet2 = pet;
        
        pet2 = new Pet("cat", "Kitty", 2, FEMALE);
        
        //String name = pet.name;
        String name = pet.getName();
        
        System.out.println("name = " + name);
        
        System.out.println("pet = " + pet.getName());
        System.out.println("pet2 = " + pet2.getName());
        
        
        Dog dog = new Dog("Chief", 3, MALE);
        System.out.println(dog.getName() + " is " + dog.getAge() + " years old.");
        dog.birthday();
        System.out.println(dog.getName() + " is " + dog.getAge() + " years old.");
        dog.dogBirthday();
        System.out.println(dog.getName() + " is " + dog.getAge() + " years old.");
        
        
        Dog dog2 = new Dog("Halo", 11, FEMALE);
        System.out.println(dog2.getName() + " is " + dog2.getAge() + " years old.");
        dog2.birthday();
        System.out.println(dog2.getName() + " is " + dog2.getAge() + " years old.");
        dog2.dogBirthday();
        System.out.println(dog2.getName() + " is " + dog2.getAge() + " years old.");
        
        
        /* from jan 25 */
        Cat cat = new Cat("KittyNigga", 2, FEMALE);
        
        /* implicit casting */
        Pet pet3 = cat;
        
        /* explicit casting */
        Cat cat2 = (Cat)pet3;
        cat2.meow();
        System.out.println("break");
        cat2.meow(3);
    }
    
}
