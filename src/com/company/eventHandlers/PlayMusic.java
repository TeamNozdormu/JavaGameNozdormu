package com.company.eventHandlers;

import javax.sound.sampled.*;

public class PlayMusic {

    private Clip clip;

    // Change file name to match yours, of course
    public static PlayMusic empire = new PlayMusic("/Sounds/SithEmpireMusic.wav");
    public static PlayMusic rebels = new PlayMusic("/Sounds/RebelsMusic.wav");
    public static PlayMusic fire = new PlayMusic("/Sounds/BlasterFire.wav");
    public static PlayMusic boom = new PlayMusic("/Sounds/Explosion.wav");

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