package io.code4all.notpokemon;

import io.code4all.notpokemon.game_objects.GameObject;
import io.code4all.notpokemon.game_objects.Solid;
import io.code4all.notpokemon.game_objects.pokemon.Pokemon;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Player {

    private static final int SPEED = 30;
    private Picture picture;
    private Pokemon pokemon;

    private Level level;
    private boolean move;

    public void setMove(boolean move) {
        this.move = move;
    }

    public Player() {
        move = true;
        this.picture = new Picture(160, 140, "player.png");
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
                //  if (!checkForDangerZoneBattle(x, y))
                    picture.translate(0, SPEED);
        }
    }


    private boolean noSolids(int x, int y) {
        for (Solid s : level.getSolids())
            if (checkPlayerPositionWithOtherObj(x, y, s))
                return false;
        return true;
    }

    public boolean checkPlayerPositionWithOtherObj(int x, int y, GameObject go) {
        return x + this.picture.getWidth() >= go.getPicture().getX() &&
                x <= go.getPicture().getMaxX() &&
                y + this.picture.getHeight() >= go.getPicture().getY() &&
                y <= go.getPicture().getMaxY();
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public boolean canMove() {
        return move;
    }

    public void setPosition(int x, int y) {
        this.picture.delete();
        this.picture = new Picture(x, y, "player.png");
        this.picture.draw();
    }
}
