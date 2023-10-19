package io.code4all.notpokemon.sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class BackgroundMusic  {


        public static void playMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File("src/io/code4all/notpokemon/sound/music/test.wav");
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);


    }
}







