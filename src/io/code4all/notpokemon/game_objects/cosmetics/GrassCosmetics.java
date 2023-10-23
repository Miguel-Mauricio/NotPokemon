package io.code4all.notpokemon.game_objects.cosmetics;

public class GrassCosmetics extends Cosmetics {
    public GrassCosmetics(int x, int y){
        setPicture(x, y, "bigGrass.png");
        this.picture.draw();
    }


    public String getMessage(){
        return "Fake Grass.";
    }
}

