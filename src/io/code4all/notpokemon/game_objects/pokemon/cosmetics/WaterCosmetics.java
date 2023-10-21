package io.code4all.notpokemon.game_objects.pokemon.cosmetics;

import io.code4all.notpokemon.game_objects.pokemon.cosmetics.Cosmetics;

public class WaterCosmetics extends Cosmetics {
    public WaterCosmetics(int x, int y){
        setPicture(x, y, "io/code4all/notpokemon/pictures/dangerWater.png");
        this.picture.draw();
    }


    public String getMessage(){
        return "Not real water";
    }
}

