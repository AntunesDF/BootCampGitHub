package com.academiadecodigo.spaceinvaders;

import com.academiadecodigo.spaceinvaders.gameobjects.*;
import com.academiadecodigo.spaceinvaders.managers.AssetManager;
import com.academiadecodigo.spaceinvaders.managers.GameObjectManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by tomazsaraiva on 21/10/15.
 */
public class WorldController implements GestureDetector.GestureListener {

    public static GameObjectManager gameObjectManager;

    public Spaceship spaceship;
    private InvadersController invadersController;
    private boolean activeTouch;

    public WorldController () {
        init();
    }

    private void init () {

        // create gameobject manager
        gameObjectManager = new GameObjectManager();

        // create spaceship
        spaceship = new Spaceship(new Sprite(AssetManager.instance.spaceship));
        spaceship.setPosition(Main.SCREEN_WIDTH / 2, 70);

        // create houses
        float pos = Main.GAME_WIDTH / 4;

        for (int i = 0; i < 4; i++) {
            //House house = new House(new Sprite(AssetManager.instance.house));
            //house.setPosition(Math.round(pos * i + pos / 2), 150);

            Shelter shelter = new Shelter(Math.round(pos * i + pos / 2), 150);
        }

        // invaders
        invadersController = new InvadersController();

        // bottom bar
        GameObject bottomBar = new GameObject(new Sprite(AssetManager.instance.bulletPlayer));
        bottomBar.setSize(Main.GAME_WIDTH * 2, 5);
        bottomBar.setPosition(Main.GAME_WIDTH / 2, 40);
        bottomBar.setColor(Color.GREEN);

        gameObjectManager.addGameObject(bottomBar);

        Gdx.input.setInputProcessor(new GestureDetector(this));
        Gdx.input.setCatchBackKey(true);
    }

    public void update (float deltaTime) {

        gameObjectManager.update(deltaTime);

        invadersController.update(deltaTime);

        if(invadersController.getInvaders().size() == 0) {
            invadersController.createInvaders();
        }

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            spaceship.moveLeft(deltaTime);

        } else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            spaceship.moveRight(deltaTime);
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            spaceship.shoot();
        }

        if(Gdx.input.isTouched(0)) {
            if(activeTouch) {
                if(Gdx.input.getY(0) > Main.SCREEN_HEIGHT / 2) {
                    if(Gdx.input.getX(0) < Main.SCREEN_WIDTH / 2) {
                        spaceship.moveLeft(deltaTime);
                    } else {
                        spaceship.moveRight(deltaTime);
                    }
                }
            } else {
                activeTouch = true;
            }
        } else {
            activeTouch = false;
        }
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
//        if(x < Main.SCREEN_WIDTH / 2) {
//            spaceship.moveRight(Gdx.graphics.getDeltaTime());
//        } else {
//            spaceship.moveLeft(Gdx.graphics.getDeltaTime());
//        }
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        if(y < Main.SCREEN_HEIGHT / 2) {
            spaceship.shoot();
        }
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

    public void respawn() {
        spaceship.setPosition(Main.SCREEN_WIDTH / 2, 64);
    }
}
