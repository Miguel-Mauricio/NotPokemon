package io.code4all.notpokemon;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {


  private Rectangle field;

  private Picture picture;

  public Background(Rectangle field, Picture picture){
      this.field=field;
      this.picture = picture;
  }

public void draw(){
      field.draw();
      picture.draw();
}
  public Rectangle getField(){
      return field;
  }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    Picture getPicture(){
         return picture;
    }

}
