package io.code4all.notpokemon;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Test {



    public static void main(String[] args) {

        Background background1 = new Background(new Rectangle(10,10,1000,1000));
        background1.getField().draw();

        Background background2 = new Background(new Picture(10,10,"io/code4all/notpokemon/pictures/grassbackground.jpg"));
        background2.getPicture().draw();

        Player player = new Player(new Picture(10,10, "io/code4all/notpokemon/pictures/ashDown.png"));
        player.getPicture().draw();


        new Handler(player);
    }
}
