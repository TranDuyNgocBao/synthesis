/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.object;

import java.awt.Color;
import java.awt.Graphics;
import org.graphics.Renderer;

/**
 *
 * @author ADMIN
 */
public class Platform extends Sprite{
    
    public Platform(float posX, float posY, float width, float height) {
        super(posX, posY);
        
        this.width = width;
        this.height = height;
    }
    
    public void render(Graphics g){
        g.setColor(new Color(110, 70, 40));
        g.fillRect((int) (posX - width / 2) - (int) Renderer.canX + Renderer.gameWidth / 2, 
                (int) (posY - height / 2) - (int) Renderer.canY + Renderer.gameHeight / 2, (int)width, (int)height);
    }   
}
