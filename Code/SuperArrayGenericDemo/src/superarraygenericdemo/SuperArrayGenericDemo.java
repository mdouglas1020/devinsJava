/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superarraygenericdemo;

/**
 *
 * @author devincargill
 */
public class SuperArrayGenericDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Integer[] intArray = {5, 4, 3, 2, 1};
        Double[] dblArray = {2.3, 4.3, 6.3, 7.3, 8.5};
        
        SuperArray<Integer> integerArray = new SuperArray<Integer>(intArray);
        integerArray.displayArray();
        
        SuperArray<Double> doubleArray = new SuperArray<Double>(dblArray);
        doubleArray.displayArray();
        
        Character[] characterArray = { 'I', 'N', 'F', 'O', 'T', 'E', 'C', 'H' };
        String[] stringArray = {"one", "two", "three", "four"};
        
        SuperArray<Character> sCharacterArray = new SuperArray<Character>(characterArray);
        sCharacterArray.displayArray();
        
        SuperArray<String> sStringArray = new SuperArray<String>(stringArray);
        sStringArray.displayArray();
        
        Thing[] thingArray = { new Thing("Tweety", "bird"),
            new Thing("Empire State", "Building"),
            new Thing("Columbia", "City"),
            new Thing("Maggie", "dog")
        };
        
        SuperArray<Thing> sThingArray = new SuperArray<Thing>(thingArray);
        sThingArray.displayArray();
    }
    
    
}
