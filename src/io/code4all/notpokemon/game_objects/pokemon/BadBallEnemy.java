package io.code4all.notpokemon.game_objects.pokemon;

import io.code4all.notpokemon.Game;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class BadBallEnemy extends Pokemon {

    public BadBallEnemy() {
        super("BadBall Enemy", 3, 140, 25, 25, "FIRE");
        Picture p = new Picture(0, 0, "io/code4all/notpokemon/pictures/badBallEnemy.png");
        p.translate(Game.GAME_WIDTH - p.getWidth() - 100 - Game.PADDING, Game.GAME_HEIGHT / 2 + 100 - p.getHeight() / 2);
        picture = p;
    }

    @Override
    public String getMessage() {
        return "I'm a Bad Ball Enemy!";
    }
}
