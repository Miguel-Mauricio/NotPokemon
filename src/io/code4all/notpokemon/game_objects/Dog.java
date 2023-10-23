package io.code4all.notpokemon.game_objects;

public class Dog extends Solid {
    public Dog(int x, int y) {
        setPicture(x, y, "dog.png");
        this.picture.draw();
    }


    public String getMessage(){
        return "Not real lava";
    }

}
