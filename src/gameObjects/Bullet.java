package gameObjects;

import java.awt.*;

public class Bullet extends GameObject implements Movable {

    public Bullet(int x, int y, Direction direction) {
        super(x, y);
        setVels(direction);
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

    private void setVels(Direction direction) {
        if (direction == Direction.Down) {
            velX = 0;
            velY = 5;
        }
        if (direction == Direction.Up) {
            velX = 0;
            velY = -5;
        }
        if (direction == Direction.Right) {
            velX = 5;
            velY = 0;
        }
        if (direction == Direction.Left) {
            velX = -5;
            velY = 0;
        }
    }
}
