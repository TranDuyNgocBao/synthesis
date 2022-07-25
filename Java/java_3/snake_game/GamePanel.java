/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake_game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

/**
 *
 * @author ADMIN
 */
public class GamePanel extends JPanel implements ActionListener {
    
    static final int SCREEN_WIDTH = 700;
    static final int SCREEN_HEIGHT = 700;
    static final int UNIT_SIZE = 50;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
    static final int DELAY = 175;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    int bodyParts = 6;
    int applesEaten;
    int stick;
    int stickX;
    int stickY;
    int stickPick;
    int chair;
    int chairX;
    int chairY;
    int chairPush;
    int appleX;
    int appleY;
    char direction = 'S';
    boolean running = false;
    Timer timer;
    Random random;
    
    GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }
    
    public void startGame() {
        newApple();
        newStick();
        newChair();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    
    public void draw(Graphics g) {

        //if (running) {
        for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
            g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
            g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
        }
        
        if (applesEaten == 0) {
            g.setColor(Color.yellow);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
        } else {
            gameOver(g);
        }
        
        if (stickPick == 0) {
            g.setColor(Color.blue);
            g.fillOval(stickX, stickY, UNIT_SIZE, UNIT_SIZE);
        }
        if (chairPush == 0) {
            g.setColor(Color.white);
            g.fillOval(chairX, chairY, UNIT_SIZE, UNIT_SIZE);
        }

//            for (int i = 0; i < bodyParts; i++) {
//                if (i == 0) {
        g.setColor(Color.green);
        g.fillRect(x[0], y[0], UNIT_SIZE, UNIT_SIZE);
//                } else {
//                    g.setColor(new Color(45, 180, 0));
////                    g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
//                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
//                }
//            }
//            g.setColor(Color.red);
//            g.setFont(new Font("Ink Free", Font.BOLD, 40));
//            FontMetrics metrics = getFontMetrics(g.getFont());
//            g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + applesEaten)) / 2, g.getFont().getSize());
        //} else {
        //gameOver(g);
        //}
    }
    
    public void newApple() {
        appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
    }
    
    public void newStick() {
        stickX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        stickY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
    }
    
    public void newChair() {
        chairX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        chairY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
    }
    
    public void move() {
//        for (int i = bodyParts; i > 0; i--) {
//            x[i] = x[i - 1];
//            y[i] = y[i - 1];
//        }
        switch (direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                direction = 'S';
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                direction = 'S';
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                direction = 'S';
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                direction = 'S';
                break;
        }
    }
    
    public void checkApple() {
        if ((x[0] == appleX) && (y[0] == appleY)) {
            //bodyParts++;
            if (stickPick != 0 && chairPush != 0) {
                applesEaten++;
            }
            //newApple();
        }
        
        if ((x[0] == stickX) && (y[0] == stickY)) {
            //bodyParts++;
            stickPick++;
            //newApple();
        }
        
        if ((x[0] == chairX) && (y[0] == chairY)) {
            //bodyParts++;
            chairPush++;
            //newApple();
        }
        
    }
    
    public void checkCollisions() {
        //checks if head collides with body
//        for (int i = bodyParts; i > 0; i--) {
//            if ((x[0] == x[i]) && (y[0] == y[i])) {
//                running = false;
//            }
//        }
        //check if head touches left border
        if (x[0] < 0) {
            x[0] += UNIT_SIZE;
        }
        //check if head touches right border
        if (x[0] > SCREEN_WIDTH) {
            x[0] -= UNIT_SIZE;
        }
        //check if head touches top border
        if (y[0] < 0) {
            y[0] += UNIT_SIZE;
        }
        //check if head touches bottom border
        if (y[0] > SCREEN_HEIGHT) {
            y[0] -= UNIT_SIZE;
        }
        
        if (!running) {
            timer.stop();
        }
    }
    
    public void gameOver(Graphics g) {
        //Score
//        g.setColor(Color.red);
//        g.setFont(new Font("Ink Free", Font.BOLD, 40));
//        FontMetrics metrics1 = getFontMetrics(g.getFont());
//        g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: " + applesEaten)) / 2, g.getFont().getSize());
        //Game Over text
//        g.setColor(Color.red);
//        g.setFont(new Font("Ink Free", Font.BOLD, 75));
//        FontMetrics metrics2 = getFontMetrics(g.getFont());
//        g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 2);

        g.setColor(Color.GREEN);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Congratulation!", (SCREEN_WIDTH - metrics2.stringWidth("Congratulation!")) / 2, SCREEN_HEIGHT / 2);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (running) {
            move();
            checkApple();
            if (applesEaten != 0) {
                running = false;
            }
            checkCollisions();
        }
        repaint();
    }
    
    public class MyKeyAdapter extends KeyAdapter {
        
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction != 'R' && direction == 'S') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L' && direction == 'S') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direction != 'D' && direction == 'S') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U' && direction == 'S') {
                        direction = 'D';
                    }
                    break;
            }
        }
    }
}
