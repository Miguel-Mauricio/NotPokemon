package io.code4all.notpokemon.sound;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class BackgroundMusic  {


        public static void playMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
            InputStream audioSrc = BackgroundMusic.class.getResourceAsStream("/test.wav");
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bufferedIn);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);


    }
}







