package io.code4all.notpokemon.game_objects.pokemon;

public class PlayerPoke extends Pokemon{

    public PlayerPoke() {
        super("PlayerPoke", 1, 100, 50, 50);
        setPicture(300, 300, "io/code4all/notpokemon/pictures/shitFly.png");
    }

    @Override
    public String getMessage() {
        return "I'm the player pokemon!";
    }
}

