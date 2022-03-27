package main;

import gameStates.StateHandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class Main {
    public volatile StateHandler handler;
    private Thread thread1;
    private Thread thread2;
    private Object lock;
    public Main() {
        handler = new StateHandler(this);
        lock = new Object();
        thread1 = new Thread(new TickThread(handler, lock));
        thread2 = new Thread(new RenderThread(handler, lock));
        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) {
        new Main();
        while (true) {
            continue;
        }
    }

    public void stopProgram() throws InterruptedException {
        handler.running = false;
        System.exit(1);
        thread2.join();
        thread1.join();
    }
}
