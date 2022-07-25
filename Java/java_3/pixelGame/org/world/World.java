/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.graphics.Renderer;
import org.object.Sprite;

/**
 *
 * @author ADMIN
 */
public class World {
    
    public static World currentWorld = null;
    
    private static long lastTime = System.nanoTime();
    
    public ArrayList<Sprite> sprites = new ArrayList<Sprite>();
    public ArrayList<Sprite> addSprites = new ArrayList<Sprite>();
    public ArrayList<Sprite> removeSprites = new ArrayList<Sprite>();
    
    private static BufferedImage backdrop = null;
    private static int backdropX = 0;
    
    public static void update(){
        //
        float deltaTime = (System.nanoTime() - lastTime) / 1000000000.0f;
        lastTime = System.nanoTime();
        
        for(Sprite sprite : currentWorld.sprites){
            sprite.update(deltaTime);
        }
        
        for(Sprite sprite : currentWorld.addSprites){
            if (!currentWorld.sprites.contains(sprite)) {
                currentWorld.sprites.add(sprite);
            }
        }
        currentWorld.addSprites.clear();
        
        for(Sprite sprite : currentWorld.removeSprites){
            if (currentWorld.sprites.contains(sprite)) {
                currentWorld.sprites.remove(sprite);
            }
        }
        currentWorld.removeSprites.clear();
    }
    
    public static void render(Graphics g){
        //
        if(backdrop != null){
            if(backdropX < Renderer.canX / 3 - Renderer.gameWidth){
                backdropX += Renderer.gameWidth;
            }
            if(backdropX > Renderer.canX / 3 + Renderer.gameWidth){
                backdropX -= Renderer.gameWidth;
            }
            
            int x = backdropX - (int) (Renderer.canX / 3);
            int bufferX = 0;
            
            if(backdropX > Renderer.canX / 3){
                bufferX = backdropX - Renderer.gameWidth - (int) (Renderer.canX / 3);
            }else{
                bufferX = backdropX + Renderer.gameWidth - (int) (Renderer.canX / 3);
            }
            
            g.drawImage(backdrop, x, 0, Renderer.gameWidth, Renderer.gameHeight, null);
            g.drawImage(backdrop, bufferX, 0, Renderer.gameWidth, Renderer.gameHeight, null);
        }else{
            try {
                backdrop = Renderer.loadImage("/resources/images/backdrop.png");
            } catch (IOException ex) {
                Logger.getLogger(World.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        for(Sprite sprite : currentWorld.sprites){
            sprite.render(g);
        }
    }
    
    public void addSprite (Sprite sprite){
        if(!addSprites.contains(sprite)){
            addSprites.add(sprite);
        }
    }
    
    public void removeSprite (Sprite sprite){
        if(!removeSprites.contains(sprite)){
            removeSprites.add(sprite);
        }
    }
    
}
