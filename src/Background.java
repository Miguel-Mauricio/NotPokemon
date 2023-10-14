import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {


  private Rectangle field;

  private Picture grass;

  public Background(Rectangle field){
      this.field=field;
  }


  public Rectangle getField(){
      return field;
  }



     public Background(Picture field){
         this.grass= field;

    }

    Picture getPicture(){
         return grass;
    }

}
