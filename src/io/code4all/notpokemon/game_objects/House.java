package io.code4all.notpokemon.game_objects;

public class House extends Solid {
    public House(int x, int y) {
        setPicture(x, y, "io/code4all/notpokemon/pictures/house.png");
        this.picture.draw();
    }

    @Override
    public String getMessage() {
        return "I'm a House!!!!";
    }
}
