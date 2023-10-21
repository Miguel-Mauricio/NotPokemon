package io.code4all.notpokemon;

import io.code4all.notpokemon.game_objects.pokemon.PlayerPoke;
import io.code4all.notpokemon.game_objects.pokemon.Pokemon;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PopupMessage {
    private Picture specialAttackBook;
    private Picture normalAttackBook;
    private boolean showing;

    public PopupMessage(){
        this.specialAttackBook = new Picture(Game.GAME_WIDTH/2 + Game.PADDING, Game.GAME_HEIGHT - Game.PADDING, "io/code4all/notpokemon/pictures/specialAttacksBook.png");
        this.specialAttackBook.translate(-specialAttackBook.getWidth()/2, -specialAttackBook.getHeight());
        this. normalAttackBook= new Picture(Game.GAME_WIDTH/2 + Game.PADDING, Game.GAME_HEIGHT - Game.PADDING, "io/code4all/notpokemon/pictures/normalAttacksBook.png");
        this.normalAttackBook.translate(-normalAttackBook.getWidth()/2, -normalAttackBook.getHeight());
    }

    public void disappear() {
        showing = false;
        this.specialAttackBook.delete();
        this.normalAttackBook.delete();
    }

    public void show(){
        showing = true;
    }

    public boolean showing() {
        return this.showing;
    }

    public void showBattleMessage(Pokemon playerPokemon) {
        if(playerPokemon.hasSpecial())
            this.specialAttackBook.draw();
        else
            this.normalAttackBook.draw();
        show();
    }
}
