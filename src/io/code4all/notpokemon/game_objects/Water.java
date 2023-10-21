package io.code4all.notpokemon.game_objects;

import io.code4all.notpokemon.game_objects.DangerZone;
import io.code4all.notpokemon.game_objects.pokemon.Pokemon;

import java.util.LinkedList;

public class  Water extends DangerZone {
    private static final int LEVEL = 2;

    public Water (int x, int y, LinkedList<Pokemon> pokemons) {
        super(Pokemon.getPokemon(LEVEL, pokemons));
        setPicture(x, y, "io/code4all/notpokemon/pictures/invisWall.png");
        this.picture.draw();
    }

    @Override
    public String getMessage() {
        return "WATER HERE!!!";
    }
}
