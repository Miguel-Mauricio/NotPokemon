package io.code4all.notpokemon;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;
    public static final int PADDING = 10;
    private Player player;
    private Background background;
    // TODO
    // We need to have 4 tiles in the future
    // for now lets work on one tile
    private Level level;

    public void init(){
        this.background = new Background(new Rectangle(PADDING, PADDING, GAME_WIDTH, GAME_HEIGHT));
        this.player = new Player();

        background.getPicture().draw();

        player.getPicture().draw();

        this.level = new Level(player);

        new Handler(player);
    }

    public void start(){
        // TODO
    }
}
