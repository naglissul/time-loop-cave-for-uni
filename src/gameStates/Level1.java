package gameStates;

import gameObjects.*;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Level1 extends GameState {
    private boolean isEnemiesExist = true;
    private final int frameStartX = 12;
    private final int frameStartY = 10;
    private final int tileDimX = 37;
    private final int tileDimY = 22;
    private Random random;
    public Level1(StateHandler handler) {
        super(handler);
    }

    private void fillMap(int map[][], String filePath) throws FileException {
        File mapFile = new File(filePath);
        Scanner mapFileScanner = null;
        try {
            mapFileScanner = new Scanner(mapFile);
            int i = 0;
            while(mapFileScanner.hasNextInt()) {
                map[i / tileDimX][i % tileDimX] = mapFileScanner.nextInt();
                i++;
            }
            mapFileScanner.close();
        } catch (FileNotFoundException e) {
            throw new FileException(filePath);
        }
    }

    @Override
    protected void init() {
        int map[][] = new int[tileDimY][tileDimX];
        random = new Random();
        try {
            fillMap(map, "res/map.txt");
        } catch (FileException e) {
            e.printStackTrace();
        }

        addObject(new Player(150, 100, this, handler));

        for (int i = 0; i < tileDimY; i++) {
             for (int j = 0; j < tileDimX; j++) {
                 if (map[i][j] == 1) {
                     addObject(new Tile(j * 16 + frameStartX,  i * 16 + frameStartY));
                 }
             }
        }

        for (int i = 0; i < 10; i++) {
            addObject(new Enemy((random.nextInt(tileDimX - 2) + 1) * 16 + frameStartX, (random.nextInt(tileDimY - 2) + 1) * 16 + frameStartY));
        }
    }

    @Override
    protected void tick() {
        isEnemiesExist = false;
        objects.forEach((obj) -> {
            if (obj.getId() == ObjectID.Enemy) {
                isEnemiesExist = true;
            }
            obj.tick();
        });
        if (!isEnemiesExist) {
            handler.setState(GameStateID.Win);
        }
    }

    @Override
    protected void render(Graphics g) {
        objects.forEach((obj) -> obj.render(g));
    }

    @Override
    protected void keyPressed(int k) {
        for (GameObject tempObject : objects) {
            if (tempObject.getId() == ObjectID.Player) {
                tempObject.keyPressed(k);
            }
        }
    }

    @Override
    protected void keyReleased(int k) {
        for (GameObject tempObject : objects) {
            if (tempObject.getId() == ObjectID.Player) {
                tempObject.keyReleased(k);
            }
        }
    }
}
