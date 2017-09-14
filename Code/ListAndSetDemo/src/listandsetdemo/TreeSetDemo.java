/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listandsetdemo;

import java.util.TreeSet;

/**
 *
 * @author devincargill
 */
public class TreeSetDemo {
    
    public static void main(String[] args){
        
        //create a tree set
        TreeSet<String> ts = new TreeSet<>();
        
        //add elements to the tree set
        ts.add("Cherry");
        ts.add("Apricot");
        ts.add("Banana");
        ts.add("Elderberry");
        ts.add("DingleBerry");
        ts.add("Fig");
        
        String last = (String)ts.last();
        System.out.println("Last: " + last);
        
        System.out.println(ts.last().getClass());
        for(String item : ts){
            System.out.println(item);
        }
    }
}
