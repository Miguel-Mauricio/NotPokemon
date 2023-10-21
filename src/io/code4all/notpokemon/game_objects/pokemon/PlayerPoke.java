package io.code4all.notpokemon.game_objects.pokemon;

import io.code4all.notpokemon.Game;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PlayerPoke extends Pokemon{

    public PlayerPoke() {
        super("PlayerPoke", 1, 100, 10, 10, "player");
        Picture p = new Picture(0,0, "io/code4all/notpokemon/pictures/godStallman.png");
        p.translate(Game.PADDING, Game.GAME_HEIGHT/2 + 100 - p.getHeight()/2);
        picture = p;
        super.setSpecial(true);
    }

    @Override
    public String getMessage() {
        return "I'm the player pokemon!";
    }

}

