package io.code4all.notpokemon;

import io.code4all.notpokemon.game_objects.pokemon.Pokemon;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class PopupMessage {
    private Text textBox;
    private boolean showing;

    public PopupMessage(){
        this.textBox = new Text(Game.GAME_WIDTH/2 - 50, Game.GAME_HEIGHT/2, "BLA BLA BLA PRESS SPACE");
        this.textBox.grow(50, 50);
    }
    public Text getTextBox() {
        return textBox;
    }

    public void setTextBox(Text textBox) {
        this.textBox = textBox;
    }

    public void disappear() {
        showing = false;
        this.textBox.delete();
    }

    public void show(){
        showing = true;
        this.textBox.draw();
    }

    public boolean showing() {
        return this.showing;
    }

    public void showBattleMessage(Pokemon pokemon) {
        showing = true;
        this.textBox.setText(pokemon.toString() + " got hit !! current health: " + pokemon.getHealth());
        this.textBox.draw();
    }
}
