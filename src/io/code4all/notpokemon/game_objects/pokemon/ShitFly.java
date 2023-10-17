package io.code4all.notpokemon.game_objects.pokemon;
import io.code4all.notpokemon.Game;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ShitFly extends Pokemon{

    public ShitFly() {
        super("ShitFly", 1, 100, 20, 50);
        Picture p = new Picture(0,0, "io/code4all/notpokemon/pictures/shitFly.png");
        p.translate(Game.GAME_WIDTH - p.getWidth() - Game.PADDING, Game.GAME_HEIGHT/2 - p.getHeight()/2);
        picture = p;
    }

    @Override
    public String getMessage() {
        return "I'm a Shit Fly!";
    }
}
