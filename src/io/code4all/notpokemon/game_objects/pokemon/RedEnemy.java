package io.code4all.notpokemon.game_objects.pokemon;

import io.code4all.notpokemon.Game;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class RedEnemy extends Pokemon{

    public RedEnemy() {
        super("RedEnemy", 3, 180, 25, 30, "FIRE");
        Picture p = new Picture(0,0, "redEnemy.png");
        p.translate(Game.GAME_WIDTH - p.getWidth() - Game.PADDING, Game.GAME_HEIGHT/2 + 100 - p.getHeight()/2);
        picture = p;
    }

    @Override
    public String getMessage() {
        return "I'm a Red Enemy!";
    }
}
