package io.code4all.notpokemon.game_objects.cosmetics;

public class LavaCosmetics extends Cosmetics{
    public LavaCosmetics(int x, int y){
        setPicture(x, y, "io/code4all/notpokemon/pictures/dangerLava.png");
        this.picture.draw();
    }


    public String getMessage(){
        return "Not real lava";
    }
}

