package gameStates;

import java.awt.*;

public abstract class GameState {
    protected StateHandler handler;
    public GameState(StateHandler handler) {
        this.handler = handler;
    }
    protected abstract void tick();
    protected abstract void render(Graphics g);
    protected abstract void keyPressed(int k);
    protected abstract void keyReleased(int k);
}
