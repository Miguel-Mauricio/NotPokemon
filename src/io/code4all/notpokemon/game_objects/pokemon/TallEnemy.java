package io.code4all.notpokemon.game_objects.pokemon;

import io.code4all.notpokemon.Game;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class TallEnemy extends Pokemon{

    public TallEnemy() {
        super("Tall Enemy", 1, 90, 10, 12, "GRASS");
        Picture p = new Picture(0, 0, "tallEnemy.png");
        p.translate(Game.GAME_WIDTH - p.getWidth() - Game.PADDING, Game.GAME_HEIGHT / 2 + 100 - p.getHeight() / 2);
        picture = p;
    }

    @Override
    public String getMessage() {
        return "I'm a Tall Enemy!";
    }
}
