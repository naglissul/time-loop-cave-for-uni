package gameObjects;

import java.awt.*;

public abstract class GameObject {
    protected int x, y, velX, velY;
    protected Color color;
    protected ObjectID id;
    protected int squareSize = 16;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public Rectangle getBounds() {
        return new Rectangle(x, y, squareSize, squareSize);
    }

    public void keyPressed(int k) {

    }
    public void keyReleased(int k) {

    }

    //setters and getters
    public void setVelX(int velX) {
        this.velX = velX;
    }
    public void setVelY(int velY) {
        this.velY = velY;
    }
    public int getVelX() {
        return velX;
    }
    public int getVelY() {
        return velY;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setId(ObjectID id) {
        this.id = id;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public ObjectID getId() {
        return id;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public Color getColor() {
        return color;
    }
    public void setSquareSize(int squareSize) {
        this.squareSize = squareSize;
    }
    public int getSquareSize() {
        return squareSize;
    }

}
