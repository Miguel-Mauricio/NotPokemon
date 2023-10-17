package io.code4all.notpokemon;

import io.code4all.notpokemon.game_objects.pokemon.Pokemon;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class BattleGround {
    private Background background;
    private Pokemon playerPokemon;
    private Pokemon pokemon;

    public BattleGround(Pokemon playerPokemon, Pokemon pokemon) {
        Picture p = new Picture(Game.PADDING, Game.PADDING, "io/code4all/notpokemon/pictures/battleBackground.png");
        this.background = new Background(new Rectangle(Game.PADDING, Game.PADDING, Game.GAME_WIDTH, Game.GAME_HEIGHT), p);
        this.playerPokemon = playerPokemon;
        this.pokemon = pokemon;
    }


    public void start() {
        while(true)
            System.out.println("HERE");
    }

    public void draw() {
        playerPokemon.getPicture().draw();
        pokemon.getPicture().draw();
    }
}
