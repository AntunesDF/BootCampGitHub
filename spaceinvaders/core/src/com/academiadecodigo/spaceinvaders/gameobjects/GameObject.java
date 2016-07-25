package com.academiadecodigo.spaceinvaders.gameobjects;

import com.academiadecodigo.spaceinvaders.WorldController;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by tomazsaraiva on 22/10/15.
 */
public class GameObject {

    protected Sprite sprite;
    protected Rectangle collisionBox;

    public GameObject(Sprite sprite) {
        this.sprite = sprite;

        WorldController.gameObjectManager.addGameObject(this);
    }

    public void setPosition(float x, float y) {
        sprite.setPosition(x - sprite.getWidth() / 2, y - sprite.getHeight() / 2);
    }

    public void setSize(int x, int y) {
        sprite.setSize(x, y);
    }

    public void setColor(Color color) {
        sprite.setColor(color);
    }

    public float getPositionX() {
        return sprite.getX() + sprite.getWidth() / 2;
    }

    public float getPositionY() {
        return sprite.getY() + sprite.getHeight() / 2;
    }

    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    public void destroy() {
        WorldController.gameObjectManager.removeGameObject(this);
    }

    public Rectangle getCollisionBox() {
        return new Rectangle(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
    }
}
