package gameStates;

import java.awt.*;

public class Win extends GameState {
    public Win(StateHandler handler) {
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
        g.setColor(Color.GREEN);
        g.drawString("You won", 300, 200);
    }

    @Override
    protected void keyPressed(int k) {

    }

    @Override
    protected void keyReleased(int k) {

    }

}
