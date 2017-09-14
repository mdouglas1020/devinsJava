/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinemidtermtesting;

/**
 *
 * @author devincargill
 */
public class class2 extends OnlineMidtermTesting {
    static int x;
    int y = 0;
    
    public class2(int y){
        x = y;
        System.out.println(x);
    }
    
    private void method1(){
        y = 3;
    }
    
    static void method(){
        y = 2;
        
    }
    
    
}
