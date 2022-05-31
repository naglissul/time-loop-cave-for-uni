package gameStates;

import main.Main;

import java.awt.*;
import java.awt.event.KeyEvent;

public class StateHandler {
    private GameState currState;
    private Main main;
    public volatile boolean running = true;
    public Object lock;
    private GameStateFactory stateFactory;

    public StateHandler(Main main) {
        this.main = main;
        stateFactory = new GameStateFactory(this);
        setState(GameStateID.Level1);
        lock = new Object();
    }

    public void setState(GameStateID stateId) {
        currState = stateFactory.getState(stateId);
    }

    public synchronized void tick() {
        currState.tick();
    }

    public synchronized void render(Graphics g) {
        currState.render(g);
    }

    public synchronized void keyPressed(int k) throws InterruptedException {
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
