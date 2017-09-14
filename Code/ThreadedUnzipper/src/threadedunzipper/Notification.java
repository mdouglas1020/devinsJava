/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadedunzipper;

/**
 *
 * @author CEDRIK
 */

//A functional interface is any interface with exactly one abstract method
@FunctionalInterface
public interface Notification {
    public void handle(double percentUnzipped, UnzipState state, String message);
}
