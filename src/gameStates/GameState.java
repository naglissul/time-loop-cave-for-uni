package gameStates;

import gameObjects.GameObject;

import java.awt.*;
import java.util.LinkedList;

public abstract class GameState {
    protected StateHandler handler;
    public LinkedList<GameObject> objects;

    public GameState(StateHandler handler) {
        this.handler = handler;
        objects = new LinkedList<GameObject>();
        init();
    }
    protected abstract void init();
    protected abstract void tick();
    protected abstract void render(Graphics g);
    protected abstract void keyPressed(int k);
    protected abstract void keyReleased(int k);
    protected void addObject(GameObject obj) {
        objects.add(obj);
    }
    protected void removeObject(GameObject obj) {
        objects.remove(obj);
    }
}
