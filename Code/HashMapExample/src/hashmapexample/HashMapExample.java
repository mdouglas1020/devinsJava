/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashmapexample;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author devincargill
 */
public class HashMapExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        HashMap hashMap1 = new HashMap();
        hashMap1.put("name", "Mary Smith");
        hashMap1.put("role", "student");
        hashMap1.put("age", "20");
        
        System.out.println(hashMap1);
        
        for(Object key : hashMap1.keySet()){
            System.out.println(key);
        }
        
        for(Object value : hashMap1.values()){
            System.out.println(value);
        }
        
        for(Object entry : hashMap1.entrySet()){
            HashMap.Entry<Object, Object> e = (HashMap.Entry<Object, Object>) entry;
            Object key = e.getKey();
            Object value = e.getValue();
            
            System.out.println(key + "=>" + value);
        }
        
        Iterator it = hashMap1.entrySet().iterator();
        while(it.hasNext()){
            HashMap.Entry pair = (HashMap.Entry) it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            //it.remove(); // avoid a concurrect modification exception
        }
        
        System.out.println("After iterator removed ");
        
        Iterator it2 = hashMap1.entrySet().iterator();
        while(it2.hasNext()){
            HashMap.Entry pair = (HashMap.Entry) it2.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it2.remove(); // avoid a concurrect modification exception
        }
                
        
    }
    
}
