/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import Controllers.TimeInterval;

/**
 *
 * @author ahmed
 */

public class Main {

    public static void main(String[] args) throws NativeHookException {
        TimeInterval service = new TimeInterval();
        try {
            GlobalScreen.registerNativeHook();		
        } catch (NativeHookException e) {
        }
        GlobalScreen.addNativeKeyListener(service.getKeyboard());
    }
}
