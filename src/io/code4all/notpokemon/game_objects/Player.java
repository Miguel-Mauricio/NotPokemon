package io.code4all.notpokemon.game_objects;

import io.code4all.notpokemon.game_objects.pokemon.Pokemon;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player extends GameObject{
    private Picture icon;    public String getMessage(){
        return this.toString();
    }

    private Pokemon pokemon;


    public Picture getIcon() {
        return icon;
    }

    public void setIcon(Picture icon) {
        setPicture(0, 0, "io/code4all/notpokemon/ashDown.png");
    }

    @Override
    public String toString() {
        return "Player{" +
                "icon=" + icon +
                ", icon=" + icon +
                '}';
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
}
