package io.code4all.notpokemon.game_objects;

import io.code4all.notpokemon.game_objects.pokemon.Pokemon;
;import java.util.LinkedList;

public abstract class DangerZone extends GameObject{
    protected Pokemon pokemon;

    public DangerZone(Pokemon pokemon) {
        this.pokemon = pokemon;

    }

    public Pokemon getPokemon(){
        return pokemon;
    }

    public void setNewPokemon(int level, LinkedList<Pokemon> pokemons) {
        pokemon = Pokemon.getPokemon(level, pokemons);
    }
}
