package io.code4all.notpokemon;

import io.code4all.notpokemon.game_objects.Solid;
import io.code4all.notpokemon.game_objects.pokemon.Pokemon;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Player {

    private static final int SPEED = 15;
    private Picture picture;
    private Pokemon pokemon;

    private Level level;

    public Player() {
        this.picture = new Picture(10, 10, "io/code4all/notpokemon/pictures/player.png");
    }


    Picture getPicture() {
        return picture;
    }

    public void moveRight() {
        // Checking for window edges
        if (picture.getX() <= Game.GAME_WIDTH - Game.PADDING * 3) {
            // Getting the possible position values
            int x = picture.getX() + SPEED;
            int y = picture.getY();
            // Checking for solids
            if (noSolids(x, y))
                picture.translate(SPEED, 0);
        }
    }

    public void moveLeft() {
        if (picture.getX() >= Game.PADDING * 2) {
            // Getting the possible position values
            int x = picture.getX() - SPEED;
            int y = picture.getY();
            if (noSolids(x, y))
                picture.translate(-SPEED, 0);
        }
    }

    public void moveUp() {
        if (picture.getY() >= Game.PADDING * 2) {
            // Getting the possible position values
            int x = picture.getX();
            int y = picture.getY() - SPEED;
            if (noSolids(x, y))
                picture.translate(0, -SPEED);
        }


    }

    public void moveDown() {
        if (picture.getY() <= Game.GAME_HEIGHT - Game.PADDING * 4) {
            // Getting the possible position values
            int x = picture.getX();
            int y = picture.getY() + SPEED;
            if (noSolids(x, y))
                picture.translate(0, SPEED);
        }
    }


    private boolean noSolids(int x, int y) {
        for (Solid s : level.getSolids())
            if (x + this.picture.getWidth() >= s.getPicture().getX() &&
                    x <= s.getPicture().getMaxX() &&
                    y + this.picture.getHeight() >= s.getPicture().getY() &&
                    y <= s.getPicture().getMaxY())
                return false;
        return true;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
