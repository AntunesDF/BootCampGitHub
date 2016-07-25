package com.academiadecodigo.spaceinvaders.gameobjects;

import com.academiadecodigo.spaceinvaders.managers.AssetManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomazsaraiva on 22/10/15.
 */
public class Shelter {

    private List<ShelterSection> sections;

    public Shelter(int x, int y) {
        createShelter(x, y);
    }

    private void createShelter(int x, int y) {

        sections = new ArrayList<ShelterSection>();

        int yPos = y + 64;

        ShelterSection section = null;

        for(int i = 0; i < 4; i++) {

            int xPos = x - 32;

            for(int j = 0; j < 4; j++) {

                section = new ShelterSection(new Sprite(AssetManager.instance.spaceship));
                section.setPosition(xPos, yPos);

                if(j == 0 && i == 0) {
                    section.setAnimation(AssetManager.instance.shelterTopLeftAnimation);
                } else if (j == 3 && i == 0) {
                    section.setAnimation(AssetManager.instance.shelterTopRightAnimation);
                } else if(j == 1 && i == 3) {
                    section.setAnimation(AssetManager.instance.shelterBottomLeftAnimation);
                } else if(j == 2 && i == 3){
                    section.setAnimation(AssetManager.instance.shelterBottomRightAnimation);
                } else {
                    section.setAnimation(AssetManager.instance.shelterCenterAnimation);
                }

                xPos += section.getCollisionBox().getWidth();
            }

            yPos -= section.getCollisionBox().getHeight();
        }
    }
}
