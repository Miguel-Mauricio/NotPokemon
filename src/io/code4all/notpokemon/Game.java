package io.code4all.notpokemon;

import io.code4all.notpokemon.game_objects.pokemon.BigEnemy;
import io.code4all.notpokemon.game_objects.pokemon.PlayerPoke;
import io.code4all.notpokemon.game_objects.pokemon.Pokemon;
import io.code4all.notpokemon.game_objects.pokemon.ShitFly;
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
    // TODO
    // We need to have 4 tiles in the future
    // for now lets work on one tile
    private Level level;

    public void init(){
        this.backgroundLevel1 = new Background(new Rectangle(PADDING, PADDING, GAME_WIDTH, GAME_HEIGHT), new Picture(PADDING, PADDING, "io/code4all/notpokemon/pictures/grassBackground.png"));
        this.player = new Player();
        this.pokemons = new LinkedList<>();
        this.popupMessage = new PopupMessage();
        // Adding player pokemon
        player.setPokemon(new PlayerPoke());
        // Add new pokemons here
        pokemons.add(new ShitFly());
        pokemons.add(new BigEnemy());

        new Handler(player, popupMessage);
    }

    public void start() throws UnsupportedAudioFileException, LineUnavailableException, IOException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        backgroundLevel1.draw();
        this.level = new Level(player, pokemons, popupMessage);
        player.setLevel(level);
        player.getPicture().draw();
        level.start();
        System.out.println("You Died!!");
    }
}
