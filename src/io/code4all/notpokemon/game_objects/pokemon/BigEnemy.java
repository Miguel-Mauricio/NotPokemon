package io.code4all.notpokemon.game_objects.pokemon;

import io.code4all.notpokemon.Game;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class BigEnemy extends Pokemon{


    public BigEnemy() {
        super("BigEnemy", 4, 250, 40, 50, "player");
        Picture p = new Picture(0,0, "demonMusk.png");
        p.translate(Game.GAME_WIDTH - p.getWidth() - 200 - Game.PADDING, Game.GAME_HEIGHT/2 + 100 - p.getHeight()/2);
        picture = p;
    }

    @Override
    public String getMessage() {
        return "I'm a Big Enemy!";
    }
}
