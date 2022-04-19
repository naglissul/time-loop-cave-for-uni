package gameObjects;

import kotlin.Pair;

import java.awt.*;

public class Bullet extends GameObject implements Movable {

    public Bullet(int x, int y, Directable direction) {
        super(x, y);
        Pair<Integer, Integer> dir = direction.direct();
        velX = dir.getFirst();
        velY = dir.getSecond();
        squareSize = 5;
        color = Color.RED;
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
}
