package gameObjects;

import gameStates.Level1;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends GameObject implements Movable {
    private int speed = 3;
    private Level1 levelHandler;
    public Player(int x, int y, Level1 levelHandler) {
        super(x, y);
        this.levelHandler = levelHandler;
        squareSize = 10;
        id = ObjectID.Player;
        color = Color.GREEN;
        velX = 0;
        velY = 0;
    }

    @Override
    public void tick() {
        move();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, squareSize, squareSize);
        g.setColor(Color.WHITE);
        g.drawRect(x, y, squareSize, squareSize);
    }

    @Override
    public void move() {
        x += velX;
        y += velY;
    }

    @Override
    public void keyPressed(int k) {
        if (k == KeyEvent.VK_RIGHT) {
            velX = speed;
        }
        if (k == KeyEvent.VK_LEFT) {
            velX = -speed;
        }
        if (k == KeyEvent.VK_UP) {
            velY = -speed;
        }
        if (k == KeyEvent.VK_DOWN) {
            velY = speed;
        }
        if (k == KeyEvent.VK_SPACE) {
            levelHandler.objects.add(new Bullet(x, y, Direction.Right));
        }
    }

    @Override
    public void keyReleased(int k) {
        if (k == KeyEvent.VK_RIGHT) {
            velX = 0;
        }
        if (k == KeyEvent.VK_LEFT) {
            velX = 0;
        }
        if (k == KeyEvent.VK_UP) {
            velY = 0;
        }
        if (k == KeyEvent.VK_DOWN) {
            velY = 0;
        }
    }

}
