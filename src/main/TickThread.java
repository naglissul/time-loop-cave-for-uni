package main;

import gameStates.StateHandler;

import java.awt.event.KeyAdapter;

public class TickThread extends KeyAdapter implements Runnable {

    private StateHandler handler;
    private Object lock;

    public TickThread(StateHandler handler, Object lock){
        this.handler = handler;
        this.lock = lock;
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (handler.running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                handler.tick();
                delta--;
            }

            synchronized (lock) {
                lock.notifyAll();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        System.exit(1);
    }
}
