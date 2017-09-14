/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listandsetdemo;

import java.util.ArrayList;
/**
 *
 * @author devincargill
 */
public class ArrayListDemo {
    
    //will be on the exam
    public static void main(String[] args){
        
        ArrayList<String> al = new ArrayList<>();
        
        System.out.println("Initial Size of array list: " + al.size());
        
        al.add("Apple");
        al.add("Banana");
        al.add("Cherry");
        al.add("Date");
        al.add("25");
        
        System.out.println("Contents of array list: " + al);
        
        al.add(1, "Apricot");
        
        System.out.println("Contents of array list: " + al);
        
        System.out.println("Size of array list after addition: " + al.size());
        
        for(String item : al){
            System.out.println(item);
        }
        
        //removing items from array list
        al.remove("Banana");
        System.out.println("Contents of array list: " + al);
        al.remove(2);
        System.out.println("Contents of array list: " + al);
        
        String first = (String)al.get(0);
        System.out.println("First: " + first);
        System.out.println(al.get(0).getClass());
        
        
        
    }
}
