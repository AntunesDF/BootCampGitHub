package com.academiadecodigo.spaceinvaders.gameobjects;

import com.academiadecodigo.spaceinvaders.WorldController;
import com.academiadecodigo.spaceinvaders.managers.AssetManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomazsaraiva on 22/10/15.
 */
public class InvadersController implements Updatable {

    private final int NUMBER_ROWS = 5;
    private final int NUMBER_INVADERS = 18;

    private final int OFFSET_ROW = 10;
    private final int OFFSET_INVADER = 10;

    private final float SPEED_INITIAL = 50;
    private final float SPEED_INCREMENT = 1.025f;

    private List<Invader> invaders;

    private float speed = 50;
    private boolean goDown = false;

    private float cooldown = 1;
    private float currentCooldown = 0;

    public InvadersController() {
        speed = SPEED_INITIAL;
        createInvaders();
    }

    public void createInvaders() {

        this.invaders = new ArrayList<Invader>();

        int yPos = Gdx.graphics.getHeight() - 64;

        Invader invader = null;

        for(int i = 0; i < NUMBER_ROWS; i++) { // row

            int xPos = 64;

            for(int j = 0; j < NUMBER_INVADERS; j++) { // column

                TextureAtlas.AtlasRegion region = AssetManager.instance.spaceship;

//                if(i < 1) {
//                    region = AssetManager.instance.invader3;
//                } else if (i < 3){
//                    region = AssetManager.instance.invader2;
//                } else {
//                    region = AssetManager.instance.invader1;
//                }

                invader = new Invader(new Sprite(region));

                if(i < 1) {
                    invader.setAnimation(AssetManager.instance.invader1Animation);
                } else if (i < 3){
                    invader.setAnimation(AssetManager.instance.invader2Animation);
                } else {
                    invader.setAnimation(AssetManager.instance.invader3Animation);
                }

                invader.setPosition(xPos, yPos);
                invader.setController(this);

                invaders.add(invader);

                xPos += invader.getCollisionBox().getWidth() + OFFSET_INVADER;
            }

            yPos -= invader.getCollisionBox().getHeight() + OFFSET_ROW;
        }
    }

    public List<Invader> getInvaders() {
        return invaders;
    }

    public float getSpeed() {
        return speed;
    }

    public void down() {
        goDown = true;
    }

    private void invertSpeed() {
        speed *= -1;
    }

    private void incrementSpeed() {
        speed *= SPEED_INCREMENT;
    }

    public void removeInvader(Invader invader) {
        invaders.remove(invader);
    }

    private void shoot() {

        if(invaders.size() > 0) {

            int randomInvader = (int)(Math.random() * invaders.size());

            invaders.get(randomInvader).shoot();
        }
    }

    @Override
    public void update(float deltaTime) {

        currentCooldown -= Gdx.graphics.getDeltaTime();

        if(currentCooldown <= 0) {

            currentCooldown = cooldown;

            shoot();
        }

        for (Invader invader : invaders) {
            invader.update(deltaTime);
        }

        if(goDown) {
            goDown = false;

            invertSpeed();
            incrementSpeed();

            for(int i = 0; i < invaders.size(); i++) {
                invaders.get(i).translate(0, -OFFSET_ROW);
            }
        }
    }

}
