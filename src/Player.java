import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Player {

    private Picture picture;

    public Player(Picture picture){
        this.picture = picture;
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

}
