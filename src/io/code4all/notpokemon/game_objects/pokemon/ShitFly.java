package io.code4all.notpokemon.game_objects.pokemon;

public class ShitFly extends Pokemon{

    public ShitFly() {
        super("ShitFly", 1, 100, 20, 50);
        setPicture(300, 300, "io/code4all/notpokemon/pictures/shitFly.png");
    }

    @Override
    public String getMessage() {
        return "I'm a Shit Fly!";
    }
}
