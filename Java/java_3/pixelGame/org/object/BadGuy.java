/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import org.graphics.Renderer;
import org.input.Input;
import org.world.World;

/**
 *
 * @author ADMIN
 */
public class BadGuy extends Mob {

    private float velocityY = 0;
    private float gravity = 300.0f;
    private float jumpHeight = 50;
    
    private int direction = 1; // 1 = right, -1 = left

    public BadGuy(float posX, float posY) {
        super(posX, posY);
        
        width = 65;
        height = 75;
    }

    public void update(float deltaTime) {
        float moveX = 0;
        
        moveX += direction * runSpeed;

        velocityY += gravity * deltaTime;

        if (doesCollide(posX, posY + 1)) {
            //
        }

        // Do COLLISIONS
        if (doesCollide(posX + moveX * deltaTime, posY)) {
            moveX -= moveX;
            direction = -direction;
        }

        if (doesCollide(posX, posY + velocityY * deltaTime)) {
            velocityY -= velocityY;
        }
        //END COLLISIONS
        
        //Edge check
        if(!doesCollide(posX + width * direction, posY + 1)){
            direction = -direction;
        }
        
        posX += moveX * deltaTime;
        posY += velocityY * deltaTime;
    }

    public void render (Graphics g) {
        int realX = (int) (posX - width / 2);
        int realY = (int) (posY - height/2);
        
        realX = realX - (int) Renderer.canX + Renderer.gameWidth / 2;
        realY = realY - (int) Renderer.canY + Renderer.gameHeight / 2;
        
        g.setColor(Color.red);
        g.fillRect(realX, realY, (int) width, (int) height);
    }
    
    public void takeDamage (float damage) {
        World.currentWorld.removeSprite(this);
    }
    
}
