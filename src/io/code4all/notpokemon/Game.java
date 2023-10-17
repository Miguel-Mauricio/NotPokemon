package io.code4all.notpokemon;

import io.code4all.notpokemon.game_objects.pokemon.PlayerPoke;
import io.code4all.notpokemon.game_objects.pokemon.Pokemon;
import io.code4all.notpokemon.game_objects.pokemon.ShitFly;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class Game {
    public static final int GAME_WIDTH = 1200;
    public static final int GAME_HEIGHT = 825;
    public static final int PADDING = 10;
    private Player player;
    private LinkedList<Pokemon> pokemons;
    private Background backgroundLevel1;
    // TODO
    // We need to have 4 tiles in the future
    // for now lets work on one tile
    private Level level;

    public void init(){
        this.backgroundLevel1 = new Background(new Rectangle(PADDING, PADDING, GAME_WIDTH, GAME_HEIGHT), new Picture(PADDING, PADDING, "io/code4all/notpokemon/pictures/grassBackground.png"));
        this.player = new Player();
        this.pokemons = new LinkedList<>();
        // Adding player pokemon
        player.setPokemon(new PlayerPoke());
        // Add new pokemons here
        pokemons.add(new ShitFly());
        player.getPicture().draw();
        this.level = new Level(player, pokemons);
        player.setLevel(level);

        new Handler(player);
    }

    public void start(){
        level.start();
        System.out.println("You Died!!");
    }
}
