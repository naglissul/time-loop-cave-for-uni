package main;

import gameStates.StateHandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class Main implements KeyListener {
    public volatile StateHandler handler;
    private Thread thread1;
    private Thread thread2;
    private Object lock;
    public Main() {
        addKeyListener(this);
        handler = new StateHandler(this);
        lock = new Object();
        thread1 = new Thread(new TickThread(handler, lock));
        thread2 = new Thread(new RenderThread(handler, lock));
        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) {
        new Main();
    }

    public void stopProgram() throws InterruptedException {
        handler.running = false;
        thread2.join();
        thread1.join();
        System.exit(1);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //Does nothing
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
