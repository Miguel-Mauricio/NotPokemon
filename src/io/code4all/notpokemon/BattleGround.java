package io.code4all.notpokemon;

import io.code4all.notpokemon.game_objects.DangerZone;
import io.code4all.notpokemon.game_objects.pokemon.Pokemon;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class BattleGround {
    private final int SPEED = 4;
    private Background background;
    
    private Pokemon playerPokemon;
    private Pokemon pokemon;
    private boolean isReady;

    private boolean playerTurn;
    private int playerPokemonInitialX;
    private int pokemonInitialX;

    public BattleGround(Pokemon playerPokemon, Pokemon pokemon) {
        Picture p = new Picture(Game.PADDING, Game.PADDING, "io/code4all/notpokemon/pictures/battleBackground.png");
        this.background = new Background(new Rectangle(Game.PADDING, Game.PADDING, Game.GAME_WIDTH, Game.GAME_HEIGHT), p);
        this.playerPokemon = playerPokemon;
        this.pokemon = pokemon;
        this.playerPokemonInitialX = playerPokemon.getPicture().getX();
        this.pokemonInitialX = pokemon.getPicture().getX();
    }


    public void draw() {
        this.background.draw();
        playerPokemon.getPicture().draw();
        pokemon.getPicture().draw();
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void setIsReady(boolean b) {
        this.isReady = b;
    }

    public boolean isReady() {
        return this.isReady;
    }

    public void fight(PopupMessage popupMessage) {/*
        System.out.println("FIGHTING");
        System.out.println("isReady = " + isReady);
        System.out.println("Player turn = " + playerTurn);
        System.out.println("Player pokemon = " + playerPokemon);
        System.out.println("Pokemon = " + pokemon);
        */
        if(!popupMessage.showing()) {
            if (!playerTurn)
                if (pokemon.isGoingRight())
                    if (pokemonInitialX >= pokemon.getPicture().getX())
                        pokemon.getPicture().translate(SPEED, 0);
                    else {
                        pokemon.setGoingRight(false);
                        playerTurn = true;
                    }
                else if (pokemon.getPicture().getX() > playerPokemon.getPicture().getMaxX())
                    pokemon.getPicture().translate(-SPEED*2, 0);
                else {
                    System.out.println("Pokemon is hiting");
                    // TODO
                    playerPokemon.hit(pokemon.getAttackDamage());
                    pokemon.setGoingRight(true);
                    System.out.println("Player Pokemon health = " + playerPokemon.getHealth());
                    popupMessage.showBattleMessage(playerPokemon);
                }
            else if (playerPokemon.isGoingLeft())
                if (playerPokemonInitialX <= playerPokemon.getPicture().getX())
                    playerPokemon.getPicture().translate(-SPEED, 0);
                else {
                    playerPokemon.setGoingLeft(false);
                    playerTurn = false;
                }
            else if (playerPokemon.getPicture().getMaxX() < pokemon.getPicture().getX())
                playerPokemon.getPicture().translate(SPEED*2, 0);
            else {
                System.out.println("Player is hitting");
                // TODO
                pokemon.hit(playerPokemon.getAttackDamage());
                playerPokemon.setGoingLeft(true);
                System.out.println("Pokemon health = " + pokemon.getHealth());
                popupMessage.showBattleMessage(pokemon);
            }
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public Background getBackground() {
        return this.background;
    }

}
