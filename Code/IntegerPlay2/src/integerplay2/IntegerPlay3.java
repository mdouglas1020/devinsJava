/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integerplay2;

/**
 *
 * @author devincargill
 */
public class IntegerPlay3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = new Integer(100);
        
        System.out.println("a: " + a + "(" + System.identityHashCode(a) + ")");
        System.out.println("b: " + a + "(" + System.identityHashCode(b) + ")");
        
        //not equal because of the new Integer() creating a new object
        if(a == b) System.out.println("a == b");
        else System.out.println("a != b");
        
        if(a.equals(b)) System.out.println("a == b");
        else System.out.println("a != b");
    }
    
}
