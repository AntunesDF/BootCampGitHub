package com.academiadecodigo.spaceinvaders;

import com.academiadecodigo.spaceinvaders.managers.AudioManager;
import com.academiadecodigo.spaceinvaders.managers.GameManager;
import com.academiadecodigo.spaceinvaders.screens.MenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class Main extends Game {

    public static GameManager gameManager;

    public static int SCREEN_WIDTH;
    public static int SCREEN_HEIGHT;
    public static int SCREEN_MARGIN = 10;

    public static int GAME_WIDTH;
    public static int GAME_HEIGHT;
	
	@Override
	public void create () {

        gameManager = new GameManager();

        AudioManager.instance.init();

        SCREEN_WIDTH = Gdx.graphics.getWidth();
        SCREEN_HEIGHT = Gdx.graphics.getHeight();

        GAME_WIDTH = SCREEN_WIDTH * 2;
        GAME_HEIGHT = SCREEN_HEIGHT;

        setScreen(new MenuScreen(this));
	}
}
