package io.code4all.notpokemon.game_objects.pokemon;

import io.code4all.notpokemon.Game;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class LavaMonster extends Pokemon{

    public LavaMonster() {
        super("D", 1, 100, 10, 10, "FIRE");
        Picture p = new Picture(0,0, "io/code4all/notpokemon/pictures/demonAlex.png");
        p.translate(Game.GAME_WIDTH - p.getWidth() - Game.PADDING, Game.GAME_HEIGHT/2 + 100 - p.getHeight()/2);
        picture = p;
    }

    @Override
    public String getMessage() {
        return "I'm a Shit Fly!";
    }
}

