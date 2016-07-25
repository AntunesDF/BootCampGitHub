package com.academiadecodigo.spaceinvaders.gameobjects;

import com.academiadecodigo.spaceinvaders.Main;
import com.academiadecodigo.spaceinvaders.managers.AssetManager;
import com.academiadecodigo.spaceinvaders.managers.AudioManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by tomazsaraiva on 22/10/15.
 */
public class Invader extends GameObject implements Hitable {

    private InvadersController controller;

    private Animation animation;
    private float stateTime;
    private TextureRegion currentFrame;

    public Invader(Sprite sprite) {
        super(sprite);
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
        sprite.setRegion(animation.getKeyFrame(0));
        sprite.setSize(animation.getKeyFrame(0).getRegionWidth(), animation.getKeyFrame(0).getRegionHeight());
    }

    public void setController(InvadersController controller) {
        this.controller = controller;
    }

    @Override
    public void draw(SpriteBatch batch) {

        stateTime += Gdx.graphics.getDeltaTime();
        currentFrame = animation.getKeyFrame(stateTime, true);
        sprite.setRegion(currentFrame);

        super.draw(batch);
    }

//    @Override
//    public void collision(GameObject other) {
//
//        if(other instanceof Bullet) {
//
//            if(!((Bullet) other).isEvil()) {
//
//                System.out.println("Invader hit by " + other);
//
//                AudioManager.instance.playInvaderKilled();
//
//                Main.gameManager.invaderKilled();
//
//                controller.removeInvader(this);
//                destroy();
//            }
//        }
//    }


    @Override
    public void hit(GameObject gameObject) {

        if(gameObject instanceof Bullet) {

            if(!((Bullet) gameObject).isEvil()) {

                AudioManager.instance.playInvaderKilled();

                Main.gameManager.invaderKilled();

                controller.removeInvader(this);
                destroy();
            }
        }
    }

    public void update(float deltaTime) {
        translate(controller.getSpeed() * deltaTime, 0);

        if( sprite.getX() >= Main.GAME_WIDTH - sprite.getWidth() - Main.SCREEN_MARGIN ||
            sprite.getX() <= 0 + Main.SCREEN_MARGIN) {
            controller.down();
        }
    }

    public void translate(float x, float y) {
        sprite.translate(x, y);
    }

    public void shoot() {
        Bullet bullet = new Bullet(new Sprite(AssetManager.instance.bulletInvader));
        bullet.setPosition(getPositionX(), getPositionY() - sprite.getHeight());
        bullet.setEvil(true);

        AudioManager.instance.playShoot();
    }
}

