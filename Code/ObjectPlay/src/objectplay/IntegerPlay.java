/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectplay;

/**
 *
 * @author devincargill
 */
public class IntegerPlay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer a = 5;
        Integer b = a;
        Integer c = 8;
        
        System.out.println("a: " + System.identityHashCode(a) + " " + a.toString());
        System.out.println("b: " + System.identityHashCode(b) + " " + b.toString());
        System.out.println("c: " + System.identityHashCode(c) + " " + c.toString());
        
        //only 2 objects before addition
        a = a + 3;
        //3 values after addition because primitive data types are imutable
        //imutable means that once the initial object is created it cannot be changed
        //if it is changed, ex. a+=3;, then a new object with the answer is created
        
        System.out.println("\na: " + System.identityHashCode(a) + " " + a.toString());
        System.out.println("b: " + System.identityHashCode(b) + " " + b.toString());
        System.out.println("c: " + System.identityHashCode(c) + " " + c.toString());
        
        //if( a == b)
        //Dont do that, it won't always work
        if(a.equals(b)){
            
        } else {
            
        }
        
        //The range of values that things can be compared with == is -128 to 128
        //Numbers outside of the range will have different hashcodes making the == fail
        //.equals() takes the value into consideration and will not fail
        Integer x = 129;
        Integer y = 129;
        
        System.out.println("\nx: " + System.identityHashCode(x) + " " + x.toString());
        System.out.println("y: " + System.identityHashCode(y) + " " + y.toString());
        
        //y += 1;
        System.out.println("\nx: " + System.identityHashCode(x) + " " + x.toString());
        System.out.println("y: " + System.identityHashCode(y) + " " + y.toString());
        
        if(x.equals(y)){
            System.out.println("They are the same object");
        } else {
            System.out.println("They are different objects");
        }
        
        
    }
    
}
