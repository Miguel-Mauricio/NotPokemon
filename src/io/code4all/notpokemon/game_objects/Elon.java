package io.code4all.notpokemon.game_objects;

import io.code4all.notpokemon.Game;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Elon extends GameObject {

    public Elon() {
        picture = new Picture(Game.GAME_WIDTH - 200, Game.GAME_HEIGHT - 100, "io/code4all/notpokemon/pictures/elonFace.png");
        picture.draw();
    }

    @Override
    public String getMessage() {
        return "Im Elon";
    }
}
