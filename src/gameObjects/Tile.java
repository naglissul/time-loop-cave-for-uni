package gameObjects;

import java.awt.*;

public class Tile extends GameObject {
    public Tile(int x, int y) {
        super(x, y);
        id = ObjectID.Tile;
        color = Color.ORANGE;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, squareSize, squareSize);
        g.setColor(Color.WHITE);
        g.drawRect(x, y, squareSize, squareSize);
    }
}

