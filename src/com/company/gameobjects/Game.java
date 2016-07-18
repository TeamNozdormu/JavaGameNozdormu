package com.company.gameobjects;

import com.company.constants.GameSettings;
import com.company.eventHandlers.KeyboardInput;
import com.company.eventHandlers.MouseInput;
import com.company.gamestates.*;
import com.company.graphics.Display;
import com.company.graphics.GameMap;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

    public GameMap map;
    private Display display;
    private boolean isRunning = false;
    private MouseInput mouseInput;
    private Thread thread;
    private KeyboardInput keyboardInput;
    private BufferStrategy bs;
    private Graphics g;
    private State gameState;
    private State menuState;
    private State gameOverState;
    private State highScoreState;
    private State chooseSideState;
    private State IntroState;
    private State IntroTaskState;

    public boolean isRunning() {
        return this.isRunning;
    }

    public void setRunning(boolean running) {
        this.isRunning = running;
    }

    private void init() {
        this.map = new GameMap(
                GameSettings.GAME_WIDTH,
                GameSettings.GAME_HEIGHT);
        this.display = new Display(
                GameSettings.GAME_NAME,
                GameSettings.GAME_WIDTH,
                GameSettings.GAME_HEIGHT);
        this.keyboardInput = new KeyboardInput(this, this.display);
        this.mouseInput = new MouseInput(this.display);
        this.gameState = new GameState();
        this.menuState = new MainMenuState();
        this.gameOverState = new GameOverState();
        this.highScoreState = new HighScoresState("Descending");
        this.chooseSideState = new ChooseSideState();
        this.IntroState = new IntroState();
        this.IntroTaskState = new IntroTaskState();
        StateManager.setCurrentState(this.menuState);
    }

    public void displayFrame() {
        //Display the current frame using the display frame;
        this.bs = this.display.getCanvas().getBufferStrategy();

        if (bs == null) {
            this.display.getCanvas().createBufferStrategy(2);
            return;
        }

        this.g = bs.getDrawGraphics();
        /////////DRAW HERE /////////////////

        g.clearRect(0, 0, GameSettings.GAME_WIDTH, GameSettings.GAME_HEIGHT);

        if (StateManager.getCurrentState() != null) {
            StateManager.getCurrentState().display(g);
        }

        ////////////// TO HERE////////////
        g.dispose();
        bs.show();
    }

    public void update() {
        if (StateManager.getCurrentState() != null) {
            StateManager.getCurrentState().update();
        }
    }

    public synchronized void start() {
        if (this.isRunning) {
            return;
        }

        this.isRunning = true;
        this.thread = new Thread(this);
        this.thread.start();
    }

    public synchronized void stop() {
        if (!isRunning) {
            return;
        }

        this.isRunning = false;

        try {
            this.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void run() {

        init();
        int fps = 36;
        double timePerTick = 1_000_000_000.0 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (this.isRunning) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                this.update();
                this.displayFrame();
                ticks++;
                delta--;
            }

            if (timer >= 1_000_000_000) {
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    }
}
