package io.code4all.notpokemon.game_objects.pokemon;
import io.code4all.notpokemon.Game;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ShitFly extends Pokemon{

    public ShitFly() {
        super("ShitFly", 1, 180, 25, 30, "FIRE");
        Picture p = new Picture(0,0, "flyEnemy.png");
        p.translate(Game.GAME_WIDTH - p.getWidth() - Game.PADDING, Game.GAME_HEIGHT/2 + 100 - p.getHeight()/2);
        picture = p;
    }

    @Override
    public String getMessage() {
        return "I'm a Shit Fly!";
    }
}
