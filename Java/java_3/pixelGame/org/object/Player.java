/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.graphics.Animation;
import org.graphics.Renderer;
import org.input.Input;
import org.world.World;

/**
 *
 * @author ADMIN
 */
public class Player extends Mob {

    private float velocityY = 0;
    private float gravity = 300.0f;
    private float jumpHeight = 100;
    
    private int direction = 1;

    public Player(float posX, float posY) {
        super(posX, posY);

        width = 98;
        height = 89;
        runSpeed = 100;
        
        Animation anim = new Animation();
        try {
            anim.images.add(Renderer.loadImage("/resources/images/player.png"));
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        animations = new Animation[]{
            anim
        };
        
//        try {
//            image = Renderer.loadImage("/resources/images/player.png");
//        } catch (IOException ex) {
//            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public void update(float deltaTime) {
        //
        float moveX = 0;

        if (Input.getKey(KeyEvent.VK_LEFT)) {
            moveX -= runSpeed;
        }

        if (Input.getKey(KeyEvent.VK_RIGHT)) {
            moveX += runSpeed;
        }
        
        if(moveX > 0) {
            direction = 1;
        }
        
        if(moveX < 0){
            direction = -1;
        }

        velocityY += gravity * deltaTime;

        if (doesCollide(posX, posY + 1)) {
            if (Input.getKeyDown(KeyEvent.VK_UP)) {
                velocityY = (float) -Math.sqrt(2 * jumpHeight * gravity);
            }
        }

        // Do COLLISIONS
        if (doesCollide(posX + moveX * deltaTime, posY)) {
            moveX -= moveX;
        }

        if (doesCollide(posX, posY + velocityY * deltaTime)) {
            velocityY -= velocityY;
        }
        //END COLLISIONS
        
        if(Input.getKeyDown(KeyEvent.VK_S)){
            Bullet bullet = new Bullet(posX, posY, direction);
            World.currentWorld.addSprite(bullet);
        }

        posX += moveX * deltaTime;
        posY += velocityY * deltaTime;
        
        Renderer.canX = posX;
        Renderer.canY = 100;
    }

//    public void render(Graphics g) {
//        g.setColor(Color.green);
//        g.drawRect((int) (posX - width / 2), (int) (posY - height / 2), (int) width, (int) height);
//    }
}
