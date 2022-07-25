/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.object;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.graphics.Animation;
import org.graphics.Renderer;
import org.world.World;

/**
 *
 * @author ADMIN
 */
public class Bullet extends Sprite{
    
    public int direction = 1; // -1 = left, 1 = right
    public float speed = 400.0f;
    public float damage = 10.0f;
    
    public Bullet(float posX, float posY, int direction) {
        super(posX, posY);
        this.direction = direction;
        width = 10;
        height = 10;
        isSolid = false;
        
        Animation anim = new Animation();
        try {
            anim.images.add(Renderer.loadImage("/resources/images/bullet_0.png"));
            anim.images.add(Renderer.loadImage("/resources/images/bullet_1.png"));
        } catch (IOException ex) {
            Logger.getLogger(Bullet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Animation anim2 = new Animation();
        try {
            anim.images.add(Renderer.loadImage("/resources/images/bullet_0_left.png"));
            anim.images.add(Renderer.loadImage("/resources/images/bullet_1_left.png"));
        } catch (IOException ex) {
            Logger.getLogger(Bullet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        animations = new Animation[]{
            anim, anim2
        };
    }
    
    public void update(float deltaTime){
        float moveX = 0;
        
        moveX += speed * direction;
        
//        if(direction == 0){
//            moveX -= speed;
//        }else{
//            moveX += speed;
//        }
        
        posX += moveX * deltaTime;
        
        if(direction > 0){
            currentAnimation = 0;
        }
        
        if(direction < 0){
            currentAnimation = 1;
        }
        
        Sprite[] colliders = getColliders(posX, posY);
        
        if(colliders.length > 0){
            for(Sprite sprite : colliders){
                if(sprite instanceof BadGuy){
                    BadGuy badGuy = (BadGuy) sprite;
                    badGuy.takeDamage(damage);
                    World.currentWorld.removeSprite(this);
                }
            }
        }
    }
    
//    public void render (Graphics g) {
//        animations[currentAnimation].playAnimation();
//        super.render(g);
//    }
    
//    public void render(Graphics g){
//        g.setColor(Color.red);
//        g.fillOval((int) (posX - width / 2), (int) (posY - height / 2), (int) width, (int) height);
//    }
    
}
