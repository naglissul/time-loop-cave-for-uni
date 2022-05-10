package gameStates;

import main.Main;

import java.awt.*;
import java.awt.event.KeyEvent;

public class StateHandler {
    private GameState currState;
    private Main main;
    public volatile boolean running = true;
    public Object lock;

    public StateHandler(Main main) {
        this.main = main;
        setState(GameStateID.Level1);
        lock = new Object();
    }

    public void setState(GameStateID state) {
        if (state == GameStateID.Win) {
            currState = new Win(this);
        }
        if (state == GameStateID.Level1) {
            currState = new Level1(this);
        }
        if (state == GameStateID.GameOver) {
            currState = new GameOver(this);
        }
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
