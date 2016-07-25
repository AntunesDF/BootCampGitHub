package com.academiadecodigo.spaceinvaders.managers;

import com.academiadecodigo.spaceinvaders.WorldController;
import com.academiadecodigo.spaceinvaders.screens.GameScreen;

/**
 * Created by tomazsaraiva on 22/10/15.
 */
public class GameManager {

    private GameScreen gameScreen;

    private final int INVADER_SCORE = 10;
    private final int MAX_LIVES = 3;

    private float highscore;
    private float score;

    private int currentLives = 0;

    public void setGameScreen(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public void invaderKilled() {
        score += INVADER_SCORE;
    }

    public float getScore() {
        return score;
    }

    public void resetScore() { score = 0; }

    public int getLives() {
        return currentLives;
    }

    public void restoreLives() {
        currentLives = MAX_LIVES;
    }

    public void lostLife() {
        currentLives--;
    }
}
