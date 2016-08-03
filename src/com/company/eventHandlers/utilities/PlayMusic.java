package com.company.eventHandlers.utilities;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public final class PlayMusic {

    public static PlayMusic archer = new PlayMusic("/Sounds/SithEmpireMusic.wav");
    public static PlayMusic mage = new PlayMusic("/Sounds/RebelsMusic.wav");
    public static PlayMusic fire = new PlayMusic("/Sounds/FireBall.wav");
    public static PlayMusic boom = new PlayMusic("/Sounds/Explosion.wav");

    private Clip clip;

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