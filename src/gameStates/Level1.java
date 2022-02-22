package gameStates;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Level1 extends GameState {
    private boolean draw = false;
    public Level1(StateHandler handler) {
        super(handler);
    }

    @Override
    protected void tick() {

    }

    @Override
    protected void render(Graphics g) {
        g.setColor(Color.green);
        if (draw) {
            g.fillRect(50, 50, 20, 20);
        }
    }

    @Override
    protected void keyPressed(int k) {
        if (k == KeyEvent.VK_E) {
            draw = true;
        }
    }

    @Override
    protected void keyReleased(int k) {
        if (k == KeyEvent.VK_E) {
            draw = false;
        }
    }
}
