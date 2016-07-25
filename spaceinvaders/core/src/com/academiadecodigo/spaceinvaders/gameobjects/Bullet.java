package com.academiadecodigo.spaceinvaders.gameobjects;

import com.academiadecodigo.spaceinvaders.WorldController;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by tomazsaraiva on 21/10/15.
 */
public class Bullet extends GameObject implements Updatable, Collidable {

    private int speed = 300;
    private boolean evil = false;

    public Bullet(Sprite sprite) {
        super(sprite);

        sprite.setColor(Color.GREEN);
    }

    public void setEvil(boolean evil) {
        this.evil = evil;

        if(evil) {
            speed *= -1;
            sprite.setColor(Color.WHITE);
        }
    }

    public boolean isEvil() {
        return evil;
    }

    @Override
    public void update(float deltaTime) {
        sprite.translate(0, speed * deltaTime);
    }

    @Override
    public void collision(GameObject gameObject) {

        if(!evil || (evil && !(gameObject instanceof Invader))) {
            destroy();
        }
    }
}
