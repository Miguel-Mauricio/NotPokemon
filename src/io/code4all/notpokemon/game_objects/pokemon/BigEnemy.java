package io.code4all.notpokemon.game_objects.pokemon;

import io.code4all.notpokemon.Game;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class BigEnemy extends Pokemon{


    public BigEnemy() {
        super("BigEnemy", 2, 200, 20, 50, "grass");
        Picture p = new Picture(0,0, "io/code4all/notpokemon/pictures/pokemonBigEnemy.png");
        p.translate(Game.GAME_WIDTH - p.getWidth() - Game.PADDING, Game.GAME_HEIGHT/2 - p.getHeight()/2);
        picture = p;
    }

    @Override
    public String getMessage() {
        return "I'm a Big Enemy!";
    }
}
