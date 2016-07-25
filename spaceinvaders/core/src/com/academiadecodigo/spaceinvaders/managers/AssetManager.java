package com.academiadecodigo.spaceinvaders.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by tomazsaraiva on 21/10/15.
 */
public class AssetManager {

    public static final String TEXTURE_ATLAS_OBJECT = "images/pack.atlas";

    public static final AssetManager instance = new AssetManager();

    private AssetManager() {}

    public AtlasRegion spaceship;
    public AtlasRegion house;
    public AtlasRegion bulletPlayer;
    public AtlasRegion bulletInvader;

    private AtlasRegion invader1;
    private AtlasRegion invader2;
    private AtlasRegion invader3;

    public Animation invader1Animation;
    public Animation invader2Animation;
    public Animation invader3Animation;

    private AtlasRegion shelterCenter;
    private AtlasRegion shelterTopLeft;
    private AtlasRegion shelterTopRight;
    private AtlasRegion shelterBottomLeft;
    private AtlasRegion shelterBottomRight;

    public Animation shelterCenterAnimation;
    public Animation shelterTopLeftAnimation;
    public Animation shelterTopRightAnimation;
    public Animation shelterBottomLeftAnimation;
    public Animation shelterBottomRightAnimation;

    public void init () {

        // load texture atlas
        TextureAtlas atlas = new TextureAtlas(Gdx.files.internal(TEXTURE_ATLAS_OBJECT));

        // load atlas regions
        spaceship = atlas.findRegion("spaceship");

        bulletPlayer = atlas.findRegion("bullet_player");
        bulletInvader = atlas.findRegion("bullet_invader");

        house = atlas.findRegion("center");

        invader1 = atlas.findRegion("Invader1");
        invader2 = atlas.findRegion("Invader2");
        invader3 = atlas.findRegion("Invader3");

        invader1Animation = getAnimation(invader1, 2, 1, 1 / 4f);
        invader2Animation = getAnimation(invader2, 2, 1, 1 / 4f);
        invader3Animation = getAnimation(invader3, 2, 1, 1 / 4f);

        shelterCenter  = atlas.findRegion("center");
        shelterTopLeft = atlas.findRegion("top_left");
        shelterTopRight = atlas.findRegion("top_right");
        shelterBottomLeft = atlas.findRegion("bottom_left");
        shelterBottomRight = atlas.findRegion("bottom_right");

        shelterCenterAnimation = getAnimation(shelterCenter, 3, 1, 0);
        shelterTopLeftAnimation = getAnimation(shelterTopLeft, 3, 1, 0);
        shelterTopRightAnimation = getAnimation(shelterTopRight, 3, 1, 0);
        shelterBottomLeftAnimation = getAnimation(shelterBottomLeft, 3, 1, 0);
        shelterBottomRightAnimation = getAnimation(shelterBottomRight, 3, 1, 0);
    }

    private Animation getAnimation(AtlasRegion atlasRegion, int columns, int rows, float fps) {

        TextureRegion[][] temp =  atlasRegion.split(atlasRegion.getRegionWidth() / columns, atlasRegion.getRegionHeight() / rows);
        TextureRegion[] frames = new TextureRegion[columns * rows];

        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                frames[index++] = temp[i][j];
            }
        }

        return new Animation(fps, frames);
    }
}
