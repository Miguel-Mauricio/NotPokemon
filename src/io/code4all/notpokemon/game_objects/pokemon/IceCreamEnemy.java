package io.code4all.notpokemon.game_objects.pokemon;

import io.code4all.notpokemon.Game;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class IceCreamEnemy extends Pokemon{
    public IceCreamEnemy() {
        super("Icecream", 2, 140, 15, 17, "WATER");
        Picture p = new Picture(0,0, "io/code4all/notpokemon/pictures/iceCreamEnemy.png");
        p.translate(Game.GAME_WIDTH - p.getWidth() - Game.PADDING, Game.GAME_HEIGHT/2 + 100 - p.getHeight()/2);
        picture = p;
    }

    @Override
    public String getMessage() {
        return "I'm an Icecream!";
    }
}
