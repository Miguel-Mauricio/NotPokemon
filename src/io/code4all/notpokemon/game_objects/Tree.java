package io.code4all.notpokemon.game_objects;

public class Tree extends Solid{
    public Tree(int x, int y){
        setPicture(x, y, "invisWall.png");
        this.picture.draw();
    }


    public String getMessage(){
        return "IM A ROCK";
    }
}
