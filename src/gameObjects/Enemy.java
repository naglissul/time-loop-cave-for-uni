package gameObjects;

import java.awt.*;

public class Enemy extends GameObject implements Movable {
    private EnemyState state;
    public Enemy(int x, int y) {
        super(x, y);
        id = ObjectID.Enemy;
        state = EnemyState.Alive;
        color = Color.CYAN;
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

    public void setState(EnemyState state) {
        this.state = state;
    }
    public EnemyState getState() {
        return state;
    }
}
