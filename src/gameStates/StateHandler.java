package gameStates;

import main.Main;

import java.awt.*;
import java.awt.event.KeyEvent;

public class StateHandler {
    private GameState currState;
    private Main main;
    public boolean running = true;
    public Object lock;
    public StateHandler(Main main) {
        this.main = main;
        currState = new Level1(this);
        lock = new Object();
    }
    public synchronized void tick() {
        currState.tick();
    }
    public synchronized void render(Graphics g) {
        currState.render(g);
    }
    public void keyPressed(int k) throws InterruptedException {
        //General events
        if (k == KeyEvent.VK_ESCAPE) {
            main.stopProgram();
        }
        currState.keyPressed(k);
    }
    public void keyReleased(int k) {
        currState.keyReleased(k);
    }
}
