package com.company.eventHandlers;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PlayMusic {

    private Clip clip;

    // Change file name to match yours, of course
    public static PlayMusic music = new PlayMusic("/Sounds/ThemeMusic.wav");
    public static PlayMusic spell = new PlayMusic("/Sounds/FireBall.wav");
    public static PlayMusic arrow = new PlayMusic("/Sounds/BowFire.wav");
    public static PlayMusic death = new PlayMusic("/Sounds/Death.wav");

    public PlayMusic(String fileName) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(PlayMusic.class.getResource(fileName));
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        try {
            if (clip != null) {
                new Thread() {
                    public void run() {
                        synchronized (clip) {
                            clip.stop();
                            clip.setFramePosition(0);
                            clip.start();
                        }
                    }
                }.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        if (clip == null) return;
        clip.stop();
    }

    public void loop() {
        try {
            if (clip != null) {
                new Thread() {
                    public void run() {
                        synchronized (clip) {
                            clip.stop();
                            clip.setFramePosition(0);
                            clip.loop(Clip.LOOP_CONTINUOUSLY);
                        }
                    }
                }.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isActive() {
        return clip.isActive();
    }
}