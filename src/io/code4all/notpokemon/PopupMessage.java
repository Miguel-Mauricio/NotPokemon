package io.code4all.notpokemon;

import io.code4all.notpokemon.game_objects.pokemon.PlayerPoke;
import io.code4all.notpokemon.game_objects.pokemon.Pokemon;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PopupMessage {
    private Text textBox;
    private Picture board;
    private boolean showing;

    public PopupMessage(){
        this.board = new Picture(Game.GAME_WIDTH/2 + Game.PADDING, Game.GAME_HEIGHT - Game.PADDING, "io/code4all/notpokemon/pictures/board.png");
        this.board.translate(-board.getWidth()/2, -board.getHeight());
        this.textBox = new Text(board.getX() + 50, board.getY() + 200, "BLA BLA BLA PRESS SPACE");
        this.textBox.grow(10, 10);
    }
    public Text getTextBox() {
        return textBox;
    }

    public void setTextBox(Text textBox) {
        this.textBox = textBox;
    }

    public void disappear() {
        showing = false;
        this.board.delete();
        this.textBox.delete();
    }

    public void show(){
        showing = true;
        this.board.draw();
        this.textBox.draw();
    }

    public boolean showing() {
        return this.showing;
    }

    public void showBattleMessage(Pokemon playerPokemon) {
        if(playerPokemon.hasSpecial())
            this.textBox.setText("    Select F for Fire attack, G for Grass attack, H for Water attack or SPACE for normal attack");
        else
            this.textBox.setText(("                                 Press SPACE Bar for normal attack"));
        show();
    }
}
