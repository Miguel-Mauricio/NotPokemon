package io.code4all.notpokemon;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {
    private Player player;
    private Background background;
    // TODO
    // We need to have 4 tiles in the future
    // for now lets work on one tile
    private Level level;

    public void init(){
        this.background = new Background(new Rectangle(10, 10, 1000, 1000));
        this.player = new Player();
        this.level = new Level(player);

        background.getPicture().draw();

        player.getPicture().draw();


        new Handler(player);
    }

    public void start(){
        // TODO
    }
}
