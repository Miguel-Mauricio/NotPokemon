package io.code4all.notpokemon.game_objects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class GameObject {
    protected Picture picture;

    public abstract String getMessage();
    protected int initialX;
    protected int initialY;

    public int getInitialX() {
        return initialX;
    }

    public int getInitialY() {
        return initialY;
    }

    public Picture getPicture() {
        return this.picture;
    }

    public void setPicture(int width, int height, String str) {
        this.picture = new Picture(width, height, str);
        this.initialX = width;
        this.initialY = height;
    }

}
