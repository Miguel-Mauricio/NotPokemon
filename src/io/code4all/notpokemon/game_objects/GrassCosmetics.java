package io.code4all.notpokemon.game_objects;

public class GrassCosmetics extends Cosmetics {
    public GrassCosmetics(int x, int y){
        setPicture(x, y, "io/code4all/notpokemon/pictures/bigGrass.png");
        this.picture.draw();
    }


    public String getMessage(){
        return "Fake Grass.";
    }
}

