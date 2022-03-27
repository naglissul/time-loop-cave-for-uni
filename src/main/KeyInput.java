package main;

import gameStates.StateHandler;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private StateHandler handler;

    public KeyInput (StateHandler handler) {
        this.handler = handler;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        try {
            handler.keyPressed(e.getKeyCode());
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        handler.keyReleased(e.getKeyCode());
    }
}
