package io.code4all.notpokemon.game_objects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class GameObject {
    protected Picture picture;

    public abstract String getMessage();

    public Picture getPicture() {
        return this.picture;
    }

    public void setPicture(int width, int height, String str) {
        this.picture = new Picture(width, height, str);
    }

}
