package io.code4all.notpokemon;

import io.code4all.notpokemon.game_objects.pokemon.PlayerPoke;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class Handler implements KeyboardHandler {

    private Player player;

    private PopupMessage popupMessage;
    private Keyboard keyboard;


    public Handler(Player player, PopupMessage popupMessage) {
        this.player = player;
        this.popupMessage = popupMessage;
        keyboard = new Keyboard(this);
        createKeyboardEvents();
    }

    public void createKeyboardEvents() {
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

        KeyboardEvent keyboardEventSpace = new KeyboardEvent();
        keyboardEventSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboardEventSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventSpace);

        KeyboardEvent keyboardEventF = new KeyboardEvent();
        keyboardEventF.setKey(KeyboardEvent.KEY_F);
        keyboardEventF.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventF);

        KeyboardEvent keyboardEventG = new KeyboardEvent();
        keyboardEventG.setKey(KeyboardEvent.KEY_G);
        keyboardEventG.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventG);

        KeyboardEvent keyboardEventH = new KeyboardEvent();
        keyboardEventH.setKey(KeyboardEvent.KEY_H);
        keyboardEventH.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventH);
    }

    @Override

    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (player.canMove()) {
            switch (keyboardEvent.getKey()) {
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
        } else if (player.getPokemon().hasSpecial()) {
            switch (keyboardEvent.getKey()) {
                case KeyboardEvent.KEY_SPACE:
                    player.getPokemon().setNextTypeOfAttack("normal");
                    popupMessage.disappear();
                    break;
                case KeyboardEvent.KEY_F:
                    player.getPokemon().setNextTypeOfAttack("FIRE");
                    player.getPokemon().setSpecial(false);
                    popupMessage.disappear();
                    break;
                case KeyboardEvent.KEY_G:
                    player.getPokemon().setNextTypeOfAttack("GRASS");
                    player.getPokemon().setSpecial(false);
                    popupMessage.disappear();
                    break;
                case KeyboardEvent.KEY_H:
                    player.getPokemon().setNextTypeOfAttack("WATER");
                    player.getPokemon().setSpecial(false);
                    popupMessage.disappear();
                    break;
            }
        } else {
            switch (keyboardEvent.getKey()) {
                case KeyboardEvent.KEY_SPACE:
                    player.getPokemon().setNextTypeOfAttack("normal");
                    popupMessage.disappear();
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
