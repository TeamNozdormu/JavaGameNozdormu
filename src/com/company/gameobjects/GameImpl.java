package com.company.gameobjects;

import com.company.eventhandlers.KeyboardInput;
import com.company.eventhandlers.utilities.MouseInput;
import com.company.gameobjects.interfaces.Game;
import com.company.gamestates.AbstractState;
import com.company.gamestates.GameStateImpl;
import com.company.gamestates.interfaces.State;
import com.company.gamestates.menustates.gameplay.GameOverState;
import com.company.gamestates.menustates.gameplay.IntroState;
import com.company.gamestates.menustates.gameplay.IntroTaskState;
import com.company.gamestates.menustates.main.ChooseDifficultyStateImpl;
import com.company.gamestates.menustates.main.ChooseSideStateImpl;
import com.company.gamestates.menustates.main.HighScoresStateImpl;
import com.company.gamestates.menustates.main.MainMenuStateImpl;
import com.company.gamestates.utilities.StateManager;
import com.company.graphics.Display;
import com.company.graphics.GameMap;
import com.company.utilities.GameSettings;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameImpl implements Game, Runnable {

    public GameMap map;
    private Display display;
    private boolean isRunning = false;
    private MouseInput mouseInput;
    private Thread thread;
    private KeyboardInput keyboardInput;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;
    private State gameState;
    private State menuState;
    private State gameOverState;
    private State highScoreState;
    private State ChooseDifficulty;
    private State chooseSideState;
    private State IntroState;
    private State IntroTaskState;

    public boolean isRunning() {
        return this.isRunning;
    }

    public void setRunning(boolean running) {
        this.isRunning = running;
    }

    public GameMap getMap() {
        return this.map;
    }

    private void setMap(GameMap map) {
        this.map = map;
    }

    public Display getDisplay() {
        return this.display;
    }

    private void setDisplay(Display display) {
        this.display = display;
    }

    private MouseInput getMouseInput() {
        return this.mouseInput;
    }

    private void setMouseInput(MouseInput mouseInput) {
        this.mouseInput = mouseInput;
    }

    private Thread getThread() {
        return this.thread;
    }

    private void setThread(Thread thread) {
        this.thread = thread;
    }

    private KeyboardInput getKeyboardInput() {
        return this.keyboardInput;
    }

    private void setKeyboardInput(KeyboardInput keyboardInput) {
        this.keyboardInput = keyboardInput;
    }

    private BufferStrategy getBufferStrategy() {
        return this.bufferStrategy;
    }

    private void setBufferStrategy(BufferStrategy bufferStrategy) {
        this.bufferStrategy = bufferStrategy;
    }

    public Graphics getGraphics() {
        return this.graphics;
    }

    private void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public State getGameState() {
        return this.gameState;
    }

    private void setGameState(State gameState) {
        this.gameState = gameState;
    }

    private State getMenuState() {
        return this.menuState;
    }

    private void setMenuState(State menuState) {
        this.menuState = menuState;
    }

    private State getGameOverState() {
        return this.gameOverState;
    }

    private void setGameOverState(State gameOverState) {
        this.gameOverState = gameOverState;
    }

    private State getHighScoreState() {
        return this.highScoreState;
    }

    private void setHighScoreState(AbstractState highScoreState) {
        this.highScoreState = highScoreState;
    }

    private State getChooseDifficulty() {
        return this.ChooseDifficulty;
    }

    private void setChooseDifficulty(State chooseDifficulty) {
        ChooseDifficulty = chooseDifficulty;
    }

    private State getChooseSideState() {
        return this.chooseSideState;
    }

    private void setChooseSideState(AbstractState chooseSideState) {
        this.chooseSideState = chooseSideState;
    }

    private State getIntroState() {
        return this.IntroState;
    }

    private void setIntroState(State introState) {
        IntroState = introState;
    }

    private State getIntroTaskState() {
        return this.IntroTaskState;
    }

    private void setIntroTaskState(State introTaskState) {
        IntroTaskState = introTaskState;
    }

    private void init() {
        this.setMap(new GameMap(GameSettings.GAME_WIDTH, GameSettings.GAME_HEIGHT));
        this.setDisplay(new Display(GameSettings.GAME_NAME, GameSettings.GAME_WIDTH, GameSettings.GAME_HEIGHT));
        this.setKeyboardInput(new KeyboardInput(this, this.display));
        this.setMouseInput(new MouseInput(this.display));
        this.setGameState(new GameStateImpl());
        this.setMenuState(new MainMenuStateImpl());
        this.setChooseDifficulty(new ChooseDifficultyStateImpl());
        this.setChooseSideState(new ChooseSideStateImpl());
        this.setIntroState(new IntroState());
        this.setIntroTaskState(new IntroTaskState());
        this.setGameOverState(new GameOverState());
        this.setHighScoreState(new HighScoresStateImpl("Descending"));
        StateManager.setCurrentState(this.getMenuState());
    }

    public void displayFrame() {
        //Display the current frame using the display frame;
        this.setBufferStrategy(this.display.getCanvas().getBufferStrategy());

        if (this.getBufferStrategy() == null) {
            this.display.getCanvas().createBufferStrategy(2);
            return;
        }

        this.setGraphics(bufferStrategy.getDrawGraphics());
        /////////DRAW HERE /////////////////
        this.getGraphics().clearRect(0, 0, GameSettings.GAME_WIDTH, GameSettings.GAME_HEIGHT);

        if (StateManager.getCurrentState() != null) {
            StateManager.getCurrentState().display(graphics);
        }

        ////////////// TO HERE////////////
        this.getGraphics().dispose();
        this.getBufferStrategy().show();
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
        this.setThread(new Thread(this));
        this.getThread().start();
    }

    public synchronized void stop() {
        if (!isRunning) {
            return;
        }

        this.isRunning = false;

        try {
            this.getThread().join();
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
