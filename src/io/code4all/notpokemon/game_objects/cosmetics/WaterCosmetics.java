package io.code4all.notpokemon.game_objects.cosmetics;

public class WaterCosmetics extends Cosmetics {
    public WaterCosmetics(int x, int y){
        setPicture(x, y, "dangerWater.png");
        this.picture.draw();
    }


    public String getMessage(){
        return "Not real water";
    }
}

