package gameObjects;

import gameStates.GameStateID;
import gameStates.Level1;
import gameStates.StateHandler;
import kotlin.Pair;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends GameObject implements Movable {
    private int speed = 3;
    private Level1 levelHandler;
    private int bulletVelX, bulletVelY;
    private StateHandler handler;

    public Player(int x, int y, Level1 levelHandler, StateHandler handler) {
        super(x, y);
        this.levelHandler = levelHandler;
        this.handler = handler;
        squareSize = 10;
        id = ObjectID.Player;
        color = Color.GREEN;
        velX = 0;
        velY = 0;
    }

    @Override
    public void tick() {
        move();
        levelHandler.objects.forEach((obj) -> {if (obj.getId() == ObjectID.Enemy && obj.getBounds().intersects(getBounds())) {
            handler.setState(GameStateID.GameOver);
        }
        });
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
            bulletVelX = speed + 2;
            bulletVelY = 0;
        }
        if (k == KeyEvent.VK_LEFT) {
            velX = -speed;
            bulletVelX = -speed - 2;
            bulletVelY = 0;
        }
        if (k == KeyEvent.VK_UP) {
            velY = -speed;
            bulletVelY = -speed - 2;
            bulletVelX = 0;
        }
        if (k == KeyEvent.VK_DOWN) {
            velY = speed;
            bulletVelY = speed + 2;
            bulletVelX = 0;
        }
        if (k == KeyEvent.VK_SPACE) {
            levelHandler.objects.add(new Bullet(x, y, () -> new Pair<Integer, Integer>(bulletVelX, bulletVelY), levelHandler));
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
