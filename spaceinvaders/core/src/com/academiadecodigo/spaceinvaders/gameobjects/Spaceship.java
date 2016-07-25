package com.academiadecodigo.spaceinvaders.gameobjects;

import com.academiadecodigo.spaceinvaders.Main;
import com.academiadecodigo.spaceinvaders.managers.AssetManager;
import com.academiadecodigo.spaceinvaders.managers.AudioManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by tomazsaraiva on 22/10/15.
 */
public class Spaceship extends GameObject implements Hitable {

    private int speed = 250;

    public Spaceship(Sprite sprite) {
        super(sprite);

        sprite.setColor(Color.GREEN);
    }

    public void moveLeft(float deltaTime) {
        if(sprite.getX() > 0 + Main.SCREEN_MARGIN) {
            sprite.translate(-speed * deltaTime, 0);
        }
    }

    public void moveRight(float deltaTime) {
        if(sprite.getX() < Main.GAME_WIDTH - sprite.getWidth() - Main.SCREEN_MARGIN) {
            sprite.translate(speed * deltaTime, 0);
        }
    }

    public void shoot() {
        Bullet bullet = new Bullet(new Sprite(AssetManager.instance.bulletPlayer));
        bullet.setPosition(getPositionX(), getPositionY() + sprite.getHeight());

        AudioManager.instance.playShoot();
    }

//    @Override
//    public void collision(GameObject gameObject) {
//        if(gameObject instanceof Bullet && ((Bullet) gameObject).isEvil()) {
//            Main.gameManager.lostLife();
//        }
//    }


    @Override
    public void hit(GameObject gameObject) {
        if(gameObject instanceof Bullet && ((Bullet) gameObject).isEvil()) {
            Main.gameManager.lostLife();
        }
    }
}
