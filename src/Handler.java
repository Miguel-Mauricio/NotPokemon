import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class Handler implements KeyboardHandler {

    private Player player;

    private Keyboard keyboard;


    public Handler(Player player){
        this.player= player;
        keyboard = new Keyboard(this);
        createKeyboardEvents();
    }

    public void createKeyboardEvents(){
        KeyboardEvent keyboardEventRight = new KeyboardEvent();
        keyboardEventRight.setKey(KeyboardEvent.KEY_D);
        keyboardEventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventRight);
        KeyboardEvent keyboardEventLeft = new KeyboardEvent();
        keyboardEventLeft.setKey(KeyboardEvent.KEY_A);
        keyboardEventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventLeft);
        KeyboardEvent keyboardEventUp = new KeyboardEvent();
        keyboardEventUp.setKey(KeyboardEvent.KEY_W);
        keyboardEventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventUp);
        KeyboardEvent keyboardEventDown = new KeyboardEvent();
        keyboardEventDown.setKey(KeyboardEvent.KEY_S);
        keyboardEventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventDown);
    }

    @Override

    public void keyPressed(KeyboardEvent keyboardEvent){
        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_D:
                player.moveRight();
                break;
            case KeyboardEvent.KEY_A:
                player.moveLeft();
                break;
            case KeyboardEvent.KEY_W:
                player.moveUp();
                break;
            case KeyboardEvent.KEY_S:
                player.moveDown();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent){

    }
}
