package com.academiadecodigo.spaceinvaders;

import com.academiadecodigo.spaceinvaders.gameobjects.GameObject;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by tomazsaraiva on 21/10/15.
 */
public class WorldRenderer {

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private WorldController worldController;

    private float speed = 200;

    private float cameraLimitMin;
    private float cameraLimitMax;

    public WorldRenderer (WorldController worldController) {
        this.worldController = worldController;
        init();
    }

    private void init () {
        camera = new OrthographicCamera(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        camera.update();

        batch = new SpriteBatch();

        cameraLimitMin = Main.SCREEN_WIDTH / 2;
        cameraLimitMax = Main.GAME_WIDTH - Main.SCREEN_WIDTH / 2;
    }

    public void render () {

        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        // render world objects
        for(GameObject gameObject : WorldController.gameObjectManager.getGameObjectList()) {
            gameObject.draw(batch);
        }

        batch.end();

        if(Math.abs(worldController.spaceship.getPositionX() - camera.position.x) > 25) {
            translateCamera(speed * Math.signum(worldController.spaceship.getPositionX() - camera.position.x));
        }
    }

    public void translateCamera(float offset) {
        camera.translate(offset * Gdx.graphics.getDeltaTime(), 0);
        camera.update();
    }
}
