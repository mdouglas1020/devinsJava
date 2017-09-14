/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petstore;

/**
 *
 * @author devincargill
 */
public class Dog extends Pet {
    //constructor
    public Dog(String name, int age, Gender gender){
        super("dog", name, age, gender);
    }
    
    public void birthday(){
        age += 7;
    }
    
    public void bark(int num) {
        for(int i = 0; i < num; i++){
            System.out.println("bark");
        }
    }
    
    public void bark(){
        bark(1);
    }
}
