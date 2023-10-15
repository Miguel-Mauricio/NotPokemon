package io.code4all.notpokemon;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {


  private Rectangle field;

  private Picture grass;

  public Background(Rectangle field){
      this.field=field;
      field.draw();
      this.grass = new Picture(10, 10, "io/code4all/notpokemon/pictures/grassBackground.png");
  }


  public Rectangle getField(){
      return field;
  }



     public Background(Picture picture){
         this.grass= picture;

    }

    Picture getPicture(){
         return grass;
    }

}
