package io.code4all.notpokemon.game_objects.pokemon;

import io.code4all.notpokemon.Game;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class RedEnemy extends Pokemon{

    public RedEnemy() {
        super("RedEnemy", 3, 150, 20, 20, "FIRE");
        Picture p = new Picture(0,0, "io/code4all/notpokemon/pictures/redEnemy.png");
        p.translate(Game.GAME_WIDTH - p.getWidth() - Game.PADDING, Game.GAME_HEIGHT/2 + 100 - p.getHeight()/2);
        picture = p;
    }

    @Override
    public String getMessage() {
        return "I'm a Red Enemy!";
    }
}
