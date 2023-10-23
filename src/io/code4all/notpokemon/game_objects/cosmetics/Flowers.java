package io.code4all.notpokemon.game_objects.cosmetics;

public class Flowers extends Cosmetics{

    public Flowers(int x, int y){
        setPicture(x, y, "flowers.png");
        this.picture.draw();
    }


    public String getMessage(){
        return "Not real lava";
    }
}
