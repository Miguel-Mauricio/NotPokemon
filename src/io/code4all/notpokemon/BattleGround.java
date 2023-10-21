package io.code4all.notpokemon;

import io.code4all.notpokemon.game_objects.DangerZone;
import io.code4all.notpokemon.game_objects.pokemon.PlayerPoke;
import io.code4all.notpokemon.game_objects.pokemon.Pokemon;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class BattleGround {
    private final int SPEED = 4;
    private Background background;
    private Picture playerBoard;
    private Picture pokemonBoard;
    private Picture heart1;
    private Picture heart2;

    private Text playerBoardText;
    private Text pokemonBoardText;
    private Pokemon playerPokemon;
    private Pokemon pokemon;
    private boolean isReady;

    private boolean playerTurn;
    private int playerPokemonInitialX;
    private int pokemonInitialX;
    private Picture typePic;

    public BattleGround(Pokemon playerPokemon, Pokemon pokemon) {
        Picture p = new Picture(Game.PADDING, Game.PADDING, "io/code4all/notpokemon/pictures/battleBackground.png");
        this.background = new Background(new Rectangle(Game.PADDING, Game.PADDING, Game.GAME_WIDTH, Game.GAME_HEIGHT), p);
        this.playerPokemon = playerPokemon;
        this.pokemon = pokemon;
        this.playerPokemonInitialX = playerPokemon.getPicture().getX();
        this.pokemonInitialX = pokemon.getPicture().getX();
        this.playerBoard = new Picture(30, Game.PADDING, "io/code4all/notpokemon/pictures/woodenBoard.png");
        this.pokemonBoard = new Picture(850, Game.PADDING, "io/code4all/notpokemon/pictures/woodenBoard.png");
        this.heart1 = new Picture(100, Game.PADDING + 90, "io/code4all/notpokemon/pictures/heart.png");
        this.heart2 = new Picture(920, Game.PADDING + 90, "io/code4all/notpokemon/pictures/heart.png");
        this.playerBoardText = new Text(heart1.getMaxX() + 50, heart1.getY() + 20, String.valueOf(playerPokemon.getHealth()));
        this.pokemonBoardText = new Text(heart2.getMaxX() + 50, heart2.getY() + 20, String.valueOf(pokemon.getHealth()));
        this.playerBoardText.grow(40, 40);
        this.pokemonBoardText.grow(40, 40);


    }


    public void draw() {
        this.background.draw();
        playerPokemon.getPicture().draw();
        pokemon.getPicture().draw();
        this.playerBoard.draw();
        this.pokemonBoard.draw();
        this.heart1.draw();
        this.heart2.draw();
        this.playerBoardText.draw();
        this.pokemonBoardText.draw();
        switch (pokemon.getType()) {
            case "FIRE":
                typePic = new Picture(pokemonBoard.getMaxX() - pokemonBoard.getWidth() / 2, pokemonBoard.getMaxY(), "io/code4all/notpokemon/pictures/fireIcon.png");
                break;
            case "GRASS":
                typePic = new Picture(pokemonBoard.getMaxX() - pokemonBoard.getWidth() / 2, pokemonBoard.getMaxY(), "io/code4all/notpokemon/pictures/grassIcon.png");
                break;
            case "WATER":
                typePic = new Picture(pokemonBoard.getMaxX() - pokemonBoard.getWidth() / 2, pokemonBoard.getMaxY(), "io/code4all/notpokemon/pictures/waterIcon.png");
                break;
        }
        if (typePic != null)
            this.typePic.draw();
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

    public void fight(PopupMessage popupMessage) {
        if (!popupMessage.showing()) {
            if (!playerTurn)
                if (pokemon.isGoingRight())
                    if (pokemonInitialX >= pokemon.getPicture().getX())
                        pokemon.getPicture().translate(SPEED, 0);
                    else {
                        pokemon.setGoingRight(false);
                        popupMessage.showBattleMessage(playerPokemon);
                        playerTurn = true;
                    }
                else if (pokemon.getPicture().getX() > playerPokemon.getPicture().getMaxX())
                    pokemon.getPicture().translate(-SPEED * 2, 0);
                else {
                    System.out.println("Pokemon is hiting");
                    // TODO
                    playerPokemon.hit(pokemon.getAttackDamage(), "normal");
                    pokemon.setGoingRight(true);
                    System.out.println("Player Pokemon health = " + playerPokemon.getHealth());

                }
            else if (playerPokemon.isGoingLeft())
                if (playerPokemonInitialX <= playerPokemon.getPicture().getX())
                    playerPokemon.getPicture().translate(-SPEED, 0);
                else {
                    playerPokemon.setGoingLeft(false);
                    playerTurn = false;
                }
            else if (playerPokemon.getPicture().getMaxX() < pokemon.getPicture().getX())
                playerPokemon.getPicture().translate(SPEED * 2, 0);
            else {
                System.out.println("Player is hitting");
                // TODO
                System.out.println(playerPokemon.nextTypeOfAttack());
                pokemon.hit(playerPokemon.getAttackDamage(), playerPokemon.nextTypeOfAttack());
                playerPokemon.setGoingLeft(true);
                System.out.println("Pokemon health = " + pokemon.getHealth());
            }
        }
        playerBoardText.setText(String.valueOf(playerPokemon.getHealth()));
        pokemonBoardText.setText(String.valueOf(pokemon.getHealth()));
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

    public void cleanTables() {
        this.pokemonBoardText.delete();
        this.pokemonBoard.delete();
        this.heart2.delete();
        this.playerBoardText.delete();
        this.playerBoard.delete();
        this.heart1.delete();
        this.typePic.delete();
        this.playerPokemon.getPicture().delete();
        this.pokemon.getPicture().delete();
        this.background.delete();
    }
}
