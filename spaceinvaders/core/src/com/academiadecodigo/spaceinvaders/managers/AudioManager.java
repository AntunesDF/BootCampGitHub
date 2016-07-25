package com.academiadecodigo.spaceinvaders.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by tomazsaraiva on 22/10/15.
 */
public class AudioManager {

    private final float MUSIC_VOLUME_RUNNING = 1f;
    private final float MUSIC_VOLUME_PAUSED = 0.1f;

    public static final AudioManager instance = new AudioManager();

    private AudioManager() {
    }

    private float soundVolume = 0.25f;

    private Sound shoot;
    private Sound invaderKilled;

    private Music music;

    public void init() {

        // load sounds
        shoot = loadSound("shoot");
        invaderKilled = loadSound("invaderkilled");

        // load and start playing music
        music = Gdx.audio.newMusic(Gdx.files.internal("music/music.mp3"));
        music.setLooping(true);
        music.setVolume(MUSIC_VOLUME_RUNNING);
        music.play();
    }

    public void pause(boolean paused) {
        if(paused) {
            music.setVolume(MUSIC_VOLUME_PAUSED);
        } else {
            music.setVolume(MUSIC_VOLUME_RUNNING);
        }
    }

    public void playShoot() {
        playSound(shoot);
    }

    public void playInvaderKilled() {
        playSound(invaderKilled);
    }

    private Sound loadSound(String file) {
        return Gdx.audio.newSound(Gdx.files.internal("sounds/" + file + ".mp3"));
    }

    private void playSound(Sound sound) {
        sound.play(soundVolume);
    }
}
