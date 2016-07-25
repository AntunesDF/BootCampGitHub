package com.academiadecodigo.spaceinvaders.screens;

import com.academiadecodigo.spaceinvaders.Main;
import com.academiadecodigo.spaceinvaders.managers.AssetManager;
import com.academiadecodigo.spaceinvaders.WorldController;
import com.academiadecodigo.spaceinvaders.WorldRenderer;
import com.academiadecodigo.spaceinvaders.managers.AudioManager;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;

/**
 * Created by tomazsaraiva on 22/10/15.
 */
public class GameScreen extends AbstractGameScreen {

    private WorldController worldController;
    private WorldRenderer worldRenderer;

    private boolean paused;
    private boolean gameOver;

    private Stage stage;
    private Skin skin;

    private Label scoreValue;
    private Label livesValue;

    public GameScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {

        // set main screen
        Main.gameManager.setGameScreen(this);

        // reset score and lives
        Main.gameManager.resetScore();
        Main.gameManager.restoreLives();

        // initialize the asset manager
        AssetManager.instance.init();

        // Initialize controller and renderer
        worldController = new WorldController();
        worldRenderer = new WorldRenderer(worldController);

        // GUI
        skin = new Skin(Gdx.files.internal("data/uiskin.json"));
        stage = new Stage();

        // SCORE
        Label scoreLabel = new Label("SCORE < 1 >", skin);
        scoreLabel.setAlignment(Align.center);
        scoreLabel.setWidth(200f);
        scoreLabel.setHeight(30f);
        scoreLabel.setPosition(Main.SCREEN_MARGIN, Main.SCREEN_HEIGHT - Main.SCREEN_MARGIN - 30);
        stage.addActor(scoreLabel);

        scoreValue = new Label(Main.gameManager.getScore() + "", skin);
        scoreValue.setAlignment(Align.center);
        scoreValue.setWidth(200f);
        scoreValue.setHeight(30f);
        scoreValue.setPosition(Main.SCREEN_MARGIN + 100, Main.SCREEN_HEIGHT - Main.SCREEN_MARGIN - 30);
        scoreValue.setColor(Color.GREEN);
        stage.addActor(scoreValue);

        // LIVES
        Label livesLabel = new Label("LIVES: ", skin);
        livesLabel.setAlignment(Align.center);
        livesLabel.setWidth(200f);
        livesLabel.setHeight(30f);
        livesLabel.setPosition(Main.SCREEN_MARGIN, 5);
        stage.addActor(livesLabel);

        livesValue = new Label(Main.gameManager.getLives() + "", skin);
        livesValue.setAlignment(Align.center);
        livesValue.setWidth(200f);
        livesValue.setHeight(30f);
        livesValue.setPosition(Main.SCREEN_MARGIN + 100, 5);
        livesValue.setColor(Color.GREEN);
        stage.addActor(livesValue);
    }

    @Override
    public void render(float delta) {

        if(!paused) {
            // Update game world by the time that has passed
            // since last rendered frame.
            worldController.update(Gdx.graphics.getDeltaTime());
        }

        // Sets the clear screen color to: Black
        Gdx.gl.glClearColor(0, 0, 0, 1);

        // Clears the screen
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Render game world to screen
        worldRenderer.render();

        // update score value
        scoreValue.setText(Math.round(Main.gameManager.getScore()) + "");

        // update lives value
        livesValue.setText(Main.gameManager.getLives() + "");

        // Render GUI
        stage.draw();

        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE) || Gdx.input.isKeyJustPressed(Input.Keys.BACK)) {
            backToMenu();
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.P)) {
            paused = !paused;

            AudioManager.instance.pause(paused);
        }
    }

    private void backToMenu () {

        paused = false;

        AudioManager.instance.pause(paused);

        // switch to menu screen
        game.setScreen(new MenuScreen(game));
    }
}
