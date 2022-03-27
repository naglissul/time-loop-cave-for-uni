package main;

import gameStates.StateHandler;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class RenderThread extends Canvas implements Runnable {

    private BufferStrategy bs;
    private StateHandler handler;
    private Object lock;
    private final int WIDTH = 640;
    private final int HEIGHT = 420;

    public RenderThread(StateHandler handler, Object lock) {
        this.handler = handler;
        this.lock = lock;
        new Window(WIDTH, HEIGHT, "Time Loop Cave", this, handler);
    }

    @Override
    public void run() {
        while (handler.running) {
            synchronized (lock) {
                lock.notifyAll();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (bs == null) {
                // Creating 3 buffers, which means whatever
                this.createBufferStrategy(3);
            }
            bs = this.getBufferStrategy();
            Graphics g = bs.getDrawGraphics();

            //Filling background
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WIDTH, WIDTH);

            //Rendering objects
            handler.render(g);

            g.dispose();
            bs.show();
        }
    }
}
