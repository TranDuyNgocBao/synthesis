/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.object;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import org.graphics.Animation;
import org.graphics.Renderer;
import org.world.World;

/**
 *
 * @author ADMIN
 */
public class Sprite {
    
    public float posX = 0;
    public float posY = 0;
    
    public Animation[] animations;
    public int currentAnimation = 0;
    
    public float width = 0;
    public float height = 0;
    
    public boolean isSolid = true;
    
    public Sprite(float posX, float posY){
        this.posX = posX;
        this.posY = posY;
    }
    
    public void update(float deltaTime){
        //s
        
    }
    public void render(Graphics g){
        //
        if (animations == null || currentAnimation >= animations.length) {
            return;
        }
        
        animations[currentAnimation].playAnimation();
        
        BufferedImage image = animations[currentAnimation].getImage();
        
        if(image == null){
            return;
        }
        
        int realX = (int)posX - image.getWidth()/2;
        int realY = (int)posY - image.getHeight()/2;
        
        realX = realX - (int) Renderer.canX + Renderer.gameWidth / 2;
        realY = realY - (int) Renderer.canY + Renderer.gameHeight / 2;
        
        g.drawImage(image, realX, realY, image.getWidth(), image.getHeight(), null);
    }
    
    protected boolean doesCollide(float x, float y) {
        float myLeft = x - width / 2;
        float myRight = x + width / 2;
        float myUp = y - height / 2;
        float myDown = y + height / 2;

        for (Sprite sprite : World.currentWorld.sprites) {
            if (sprite == this || !sprite.isSolid) {
                continue;
            }

            float otherLeft = sprite.posX - sprite.width / 2;
            float otherRight = sprite.posX + sprite.width / 2;
            float otherUp = sprite.posY - sprite.height / 2;
            float otherDown = sprite.posY + sprite.height / 2;

            if (myLeft < otherRight && myRight > otherLeft && myDown > otherUp && myUp < otherDown) {
                return true;
            }
        }

        return false;
    }
    
    // Specific collisions
    protected Sprite[] getColliders(float x, float y) {
        ArrayList<Sprite> sprites = new ArrayList<Sprite>();
         
        float myLeft = x - width / 2;
        float myRight = x + width / 2;
        float myUp = y - height / 2;
        float myDown = y + height / 2;

        for (Sprite sprite : World.currentWorld.sprites) {
            if (sprite == this || !sprite.isSolid) {
                continue;
            }

            float otherLeft = sprite.posX - sprite.width / 2;
            float otherRight = sprite.posX + sprite.width / 2;
            float otherUp = sprite.posY - sprite.height / 2;
            float otherDown = sprite.posY + sprite.height / 2;

            if (myLeft < otherRight && myRight > otherLeft && myDown > otherUp && myUp < otherDown) {
                sprites.add(sprite);
            }
        }

        Sprite[] spriteArray = new Sprite[sprites.size()];
        return sprites.toArray(spriteArray);
    }
    
}
