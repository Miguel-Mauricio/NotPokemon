package io.code4all.notpokemon.game_objects;

public class Rock extends Solid{
    public Rock(){
        setPicture(30, 30, "io/code4all/notpokemon/pictures/rock.png");
    }
    public String getMessage(){
        return "IM A ROCK";
    }
}
