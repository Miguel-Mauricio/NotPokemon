package io.code4all.notpokemon.game_objects.pokemon;

import io.code4all.notpokemon.Game;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CrazyEnemy extends Pokemon{
    public CrazyEnemy() {
        super("Crazy Enemy", 2, 140, 15, 10, "WATER");
        Picture p = new Picture(0, 0, "io/code4all/notpokemon/pictures/crazyEnemy.png");
        p.translate(Game.GAME_WIDTH - p.getWidth() - Game.PADDING, Game.GAME_HEIGHT / 2 + 100 - p.getHeight() / 2);
        picture = p;
    }

    @Override
    public String getMessage() {
        return "I'm a Crazy Enemy!";
    }
}
