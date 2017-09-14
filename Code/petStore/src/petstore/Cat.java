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
public class Cat extends Pet {
    
    public Cat(String name, int age, Gender gender) {
        super("cat", name,age, gender);
    }
    
    public void meow(int num) {
        for(int i = 0; i < num; i++){
            System.out.println(getName() + " meows loud as fuck");
        }
    }
    
    public void meow() {
        meow(1);
    }
}
