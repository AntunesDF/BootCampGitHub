package com.academiadecodigo.spaceinvaders.managers;

import com.academiadecodigo.spaceinvaders.gameobjects.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by tomazsaraiva on 22/10/15.
 */
public class GameObjectManager {

    private List<GameObject> gameObjectList = new ArrayList<GameObject>();
    private List<GameObject> bulletsList = new ArrayList<GameObject>();

    private Stack<GameObject> objectsToAdd = new Stack<GameObject>();
    private Stack<GameObject> objectsToRemove = new Stack<GameObject>();

    public void addGameObject(GameObject gameObject) {
        objectsToAdd.push(gameObject);

        if(gameObject instanceof Bullet) {
            bulletsList.add(gameObject);
        }
    }

    public void removeGameObject(GameObject gameObject) {
        objectsToRemove.add(gameObject);

        if(gameObject instanceof Bullet) {
            bulletsList.remove(gameObject);
        }
    }

    public void update(float deltaTime) {

        // add all new objects to the list
        while(objectsToAdd.size() > 0) {
            gameObjectList.add(objectsToAdd.pop());
        }

        // remove all objects that were destroyed
        while(objectsToRemove.size() > 0) {
            gameObjectList.remove(objectsToRemove.pop());
        }

        // update all objects and check collisions with the bullets
        if(gameObjectList.size() > 0) {

            for (GameObject gameObject : gameObjectList) {

                if(gameObject instanceof Updatable) {
                    ((Updatable) gameObject).update(deltaTime);
                }

                if(gameObject instanceof Collidable) {
                    checkCollision(gameObject);
                }
            }
        }
    }

    private void checkCollision(GameObject gameObject) {

        for(GameObject other : gameObjectList) {

            if(gameObject != other && gameObject.getCollisionBox().overlaps(other.getCollisionBox())) {
                ((Collidable)gameObject).collision(other);

                if(other instanceof Hitable) {
                  ((Hitable) other).hit(gameObject);
                }
            }
        }
    }

    public List<GameObject> getGameObjectList() {
        return gameObjectList;
    }
}
