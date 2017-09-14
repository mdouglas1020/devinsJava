/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dc23bfilezipper;

/**
 *
 * @author devincargill
 */
public interface userAuth {
    String appUser = "devin";
    String appPass = "1234";
    String userError = "Username incorrect";
    String passError = "Password incorrect";
    String hint = "User: devin || Pass: 1234";
    int hintAttempts = 3;
    
    public int compareUser(String input);
    public int comparePass(String input);
    public void messageHint();
}
