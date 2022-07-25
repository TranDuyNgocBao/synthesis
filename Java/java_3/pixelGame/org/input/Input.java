/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author ADMIN
 */
public class Input implements KeyListener{

    private static boolean [] lastKeys = new boolean[196];
    private static boolean [] currentKeys = new boolean[196];
    
    public static boolean getKey (int keyCode){
        return currentKeys[keyCode];
    }
    
    public static boolean getKeyDown (int keyCode){
        return currentKeys[keyCode] && !lastKeys[keyCode];
    }
    
    public static boolean getKeyUp (int keyCode){
        return !currentKeys[keyCode] && lastKeys[keyCode];
    }
    
    public static void finishInput(){
        lastKeys = currentKeys.clone();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        currentKeys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        currentKeys[e.getKeyCode()] = false;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
}
