package io.code4all.notpokemon;

import io.code4all.notpokemon.game_objects.pokemon.Pokemon;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Player {

    private Picture picture;
    private Pokemon pokemon;


    public Player(){
       this.picture = new Picture(10, 10, "io/code4all/notpokemon/pictures/player.png");
    }


    Picture getPicture(){
        return picture;
}

    public void moveRight(){
        picture.translate(10,0);

    }


    public void moveLeft(){
        picture.translate(-10,0);
    }

    public void moveUp(){
        picture.translate(0,-10);


    }
    public void moveDown(){
        picture.translate(0,10);
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
}
