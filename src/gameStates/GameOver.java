package gameStates;

import java.awt.*;

public class GameOver extends GameState {
    public GameOver(StateHandler handler) {
        super(handler);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void tick() {

    }

    @Override
    protected void render(Graphics g) {
        g.setColor(Color.RED);
        g.drawString("Game Over", 300, 200);
    }

    @Override
    protected void keyPressed(int k) {

    }

    @Override
    protected void keyReleased(int k) {

    }
}
