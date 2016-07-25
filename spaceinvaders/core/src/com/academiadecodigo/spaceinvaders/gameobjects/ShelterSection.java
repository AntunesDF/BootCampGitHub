package com.academiadecodigo.spaceinvaders.gameobjects;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by tomazsaraiva on 22/10/15.
 */
public class ShelterSection extends GameObject implements Hitable {

    private int currentDamage = 0;
    private int maxDamage = 2;

    private Animation animation;
    private TextureRegion currentFrame;

    public ShelterSection(Sprite sprite) {
        super(sprite);
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;

        sprite.setRegion(animation.getKeyFrame(0));
        sprite.setSize(animation.getKeyFrame(0).getRegionWidth(), animation.getKeyFrame(0).getRegionHeight());

    }

//    @Override
//    public void collision(GameObject gameObject) {
//        if(gameObject instanceof Bullet) {
//            currentDamage ++;
//
//            if(currentDamage < maxDamage) {
//                sprite.setRegion(animation.getKeyFrame(currentDamage));
//            } else {
//                destroy();
//            }
//        }
//    }


    @Override
    public void hit(GameObject gameObject) {
        if(gameObject instanceof Bullet) {
            currentDamage ++;

            if(currentDamage < maxDamage) {
                sprite.setRegion(animation.getKeyFrame(currentDamage));
            } else {
                destroy();
            }
        }
    }
}
