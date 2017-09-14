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
@FunctionalInterface
public interface Notification {
    public void handle(double percentUnzipped, zipState state, String message);
}

