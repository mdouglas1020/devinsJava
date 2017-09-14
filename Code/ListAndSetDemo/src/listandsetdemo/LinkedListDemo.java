/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listandsetdemo;

import java.util.LinkedList;

/**
 *
 * @author devincargill
 */
public class LinkedListDemo {
    
    public static void main(String[] args){
        
        //create linked list
        LinkedList<String> ll = new LinkedList<>();
        
        //adding elements
        ll.add("Fig");
        ll.add("Banana");
        ll.add("Date");
        ll.add("Elderberry");
        ll.add("Cherry");
        
        System.out.println("OG Content of ll: " + ll);
        ll.addFirst("Strawberry");
        System.out.println("After add first: " + ll);
        ll.addLast("Fuck you again");
        System.out.println("After add last: " + ll);
        
        ll.add(1, "Fuck you");
        System.out.println("Adding by add(index, string): " + ll);
        
        System.out.println("Iterate through list: ");
        for(String item : ll){
            System.out.println(item);
        }
        
        ll.remove("Date");
        ll.remove(2);
        System.out.println("After delete: " + ll);
        
        ll.removeFirst();
        ll.removeLast();
        
        System.out.println("After deleting first and last: " + ll);
        
        //get and set a value
        Object val = ll.get(2);
        ll.set(2, (String) val + "Changed");
        
        System.out.println("After getting and setting: " + ll);
        
        String first = (String) ll.getFirst();
        System.out.println("First: " + first);
        System.out.println(ll.getFirst().getClass());
    }
}
