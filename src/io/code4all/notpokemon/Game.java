package io.code4all.notpokemon;

import io.code4all.notpokemon.game_objects.pokemon.*;
import io.code4all.notpokemon.sound.BackgroundMusic;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.LinkedList;

public class Game {
    public static final int GAME_WIDTH = 1200;
    public static final int GAME_HEIGHT = 825;
    public static final int PADDING = 10;
    public static final int DAMAGE_BOOST = 30;
    private Player player;
    private LinkedList<Pokemon> pokemons;
    private Background backgroundLevel1;
    private PopupMessage popupMessage;
    private Background startGamePic;
    // TODO
    // We need to have 4 tiles in the future
    // for now lets work on one tile
    private Level level;
    private boolean startScreen;

    public void init() throws InterruptedException {
        this.startGamePic = new Background(new Rectangle(PADDING, PADDING, GAME_WIDTH, GAME_HEIGHT), new Picture(PADDING, PADDING, "io/code4all/notpokemon/pictures/mainMenuFinal.png"));
        this.backgroundLevel1 = new Background(new Rectangle(PADDING, PADDING, GAME_WIDTH, GAME_HEIGHT), new Picture(PADDING, PADDING, "io/code4all/notpokemon/pictures/grassBackground.png"));
        this.player = new Player();
        this.pokemons = new LinkedList<>();
        this.popupMessage = new PopupMessage();
        // Adding player pokemon
        player.setPokemon(new PlayerPoke());
        // Add new pokemons here
        pokemons.add(new GrassMonster());
        pokemons.add(new BigEnemy());
        pokemons.add(new WaterMonster());
        pokemons.add(new LavaMonster());
        pokemons.add(new BadBallEnemy());
        pokemons.add(new CrazyEnemy());
        pokemons.add(new TallEnemy());
        pokemons.add(new ShitFly());
        pokemons.add(new IceCreamEnemy());
        pokemons.add(new RedEnemy());
        new Handler(player, popupMessage, this);
        startScreen = true;
        startGamePic.draw();
        while (startScreen) Thread.sleep(1000);
        startGamePic.getPicture().delete();
        startGamePic.getField().delete();
        Thread.sleep(100);
        System.out.println("HERE");
    }

    public void start() throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        startScreen = false;
        startGamePic.delete();

        backgroundLevel1.draw();
        this.level = new Level(player, pokemons, popupMessage);
        player.setLevel(level);
        System.out.println("After se level");
        player.getPicture().draw();
        Thread.sleep(200);
        level.start();
        System.out.println("You Died!!");
    }

    public boolean isOnStartScreen() {
        return startScreen;
    }

    public void setStartScreen(boolean b) {
        startScreen = b;
    }
}
