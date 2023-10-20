package io.code4all.notpokemon.game_objects;

public class Rock extends Solid{
    public Rock(int x, int y){
        setPicture(x, y, "io/code4all/notpokemon/pictures/fileIcon.png");
        this.picture.draw();
    }


    public String getMessage(){
        return "IM A ROCK";
    }
}
