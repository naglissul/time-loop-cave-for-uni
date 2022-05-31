package gameObjects;

import gameStates.Level1;
import kotlin.Pair;

import java.awt.*;

public class Bullet extends GameObject implements Movable {
    private Level1 levelHandler;
    public Bullet(int x, int y, Directable direction, Level1 levelHandler) {
        super(x, y);
        this.levelHandler = levelHandler;
        Pair<Integer, Integer> dir = direction.direct();
        velX = dir.getFirst();
        velY = dir.getSecond();
        squareSize = 5;
        color = Color.RED;
    }

    @Override
    public void tick() {
        move();
        for (int i = 0; i < levelHandler.objects.size(); i++) {
            GameObject obj = levelHandler.objects.get(i);
            if (obj.getId() == ObjectID.Enemy && obj.getBounds().intersects(getBounds())) {
                levelHandler.objects.remove(obj);
            }
        }

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
