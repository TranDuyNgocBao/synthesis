/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.game;

import org.graphics.Renderer;
import org.object.BadGuy;
import org.object.Platform;
import org.object.Player;
import org.world.World;

/**
 *
 * @author ADMIN
 */
public class Game {
    public static void main(String[] args) {
        Renderer.init();
        
        World.currentWorld = new World();
        World.currentWorld.addSprite(new Player(100,100));
        World.currentWorld.addSprite(new Platform(200,200,300,20));
        World.currentWorld.addSprite(new BadGuy(200,100));
    }
    
    public static void quit(){
        System.exit(0);
    }
}
