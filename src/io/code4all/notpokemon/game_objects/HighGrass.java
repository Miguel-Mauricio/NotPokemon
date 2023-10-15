package io.code4all.notpokemon.game_objects;

public class HighGrass extends DangerZone{
    public HighGrass(int x, int y){
        setPicture(x, y, "io/code4all/notpokemon/pictures/highGrass.png");
        this.picture.draw();
    }

    @Override
    public String getMessage() {
        return "I'm High Grass!!!";
    }
}
