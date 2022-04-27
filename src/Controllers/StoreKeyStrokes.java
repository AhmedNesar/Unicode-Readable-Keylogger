/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
/**
 *
 * @author ahmed
 */
public class StoreKeyStrokes {
    private final int keyCode;
    private final boolean pressed;
    private final long systemsTimePressedMills;
    public StoreKeyStrokes(int keyCode, boolean pressed, long systemsTimePressedMills) {
        this.keyCode = keyCode;
        this.pressed = pressed;
        this.systemsTimePressedMills = systemsTimePressedMills;
    }
    public int getKeyCode() {
        return keyCode;
    }
    public boolean isPressed() {
        return pressed;
    }

    public long getSystemsTimePressedMills() {
        return systemsTimePressedMills;
    }
    @Override
    public String toString() {
        return "KeyStorage[keyCode=" + keyCode + ",pressed=" + pressed + ",systemsTimePressedMills="
                + systemsTimePressedMills + "]";
    }
}
