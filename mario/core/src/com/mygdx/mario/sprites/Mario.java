package com.mygdx.mario.sprites;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.mario.MarioGame;

/**
 * Created by codecadet on 03/07/16.
 */
public class Mario extends Sprite {

    public World world;
    public Body b2body;

    public Mario(World world) {
        this.world = world;
        defineMario();
    }

    private void defineMario() {
        BodyDef bdef = new BodyDef();
        bdef.position.set(32 / MarioGame.PPM, 32 / MarioGame.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(5 / MarioGame.PPM);

        fdef.shape = shape;
        b2body.createFixture(fdef);
    }

}
