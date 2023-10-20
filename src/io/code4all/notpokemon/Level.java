package io.code4all.notpokemon;

import io.code4all.notpokemon.game_objects.*;
import io.code4all.notpokemon.game_objects.pokemon.Pokemon;
import io.code4all.notpokemon.sound.BackgroundMusic;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.LinkedList;

public class Level {
    private PopupMessage popupMessage;
    private Player player;
    private Solid[] solids;
    private DangerZone[] dangerZones;
    BattleGround battleGround;

    public Level(Player player, LinkedList<Pokemon> pokemons, PopupMessage popupMessage) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        this.player = player;
        this.popupMessage = popupMessage;
        solids = new Solid[6];
        solids[0] = new Rock(200, 50);
        solids[1] = new Rock(300, 400);
        solids[2] = new Tree(500, 300);
        solids[3] = new Tree(400, 200);
        solids[4] = new House(650, 200);
        solids[5] = new House(600, 300);

        dangerZones = new DangerZone[3];
        dangerZones[0] = new HighGrass(600, 50, pokemons);
        dangerZones[1] = new HighGrass(600, 70, pokemons);
        dangerZones[2] = new HighGrass(600, 160, pokemons);

        battleGround = new BattleGround(player.getPokemon(), pokemons.get(0));

        BackgroundMusic.playMusic();
    }

    public void start() {
        while (true) {
            System.out.println(player.getPokemon());
            if (player.getPokemon().isDead()) {
                System.out.println("GAME OVER BABY!!!");
                Background gameOver = new Background(new Rectangle(Game.PADDING, Game.PADDING, Game.GAME_WIDTH, Game.GAME_HEIGHT), new Picture(Game.PADDING, Game.PADDING, "io/code4all/notpokemon/pictures/gameOver.png"));
                gameOver.draw();
                return;
            }
            if (battleGround.getPokemon().getHealth() <= 0) {
                System.out.println("Resetting battleground");
                battleGround.getPokemon().reanimate();
                battleGround.getPokemon().getPicture().delete();
                player.getPokemon().getPicture().delete();
                battleGround.getBackground().getPicture().delete();
                battleGround.cleanTables();
                battleGround.setIsReady(false); // bad variable name :) sy guys
                player.setMove(true);
                for (DangerZone d : dangerZones)
                    if (player.checkPlayerPositionWithOtherObj(player.getPicture().getX(), player.getPicture().getY(), d)) {
                        // can do another number to arrange better position after exiting dangerzone
                        player.setPosition(d.getPicture().getMaxX() + 1, d.getPicture().getY() + d.getPicture().getHeight()/2);
                        player.getPokemon().gainXP(20);
                        player.getPokemon().reanimate();
                    }


                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            while (!player.getPokemon().isDead() && !battleGround.getPokemon().isDead()) {
                if (!battleGround.isReady())
                    for (DangerZone d : dangerZones) {
                        System.out.println("checking for danger");
                        if (player.checkPlayerPositionWithOtherObj(player.getPicture().getX(), player.getPicture().getY(), d) && Math.random() * 10 > 8) {
                            battleGround.setIsReady(true);
                            startBattle(d);
                        }
                    }
                else
                    battleGround.fight(popupMessage);
            }
        }
    }


    public void startBattle(DangerZone dangerZone) {
        // playTransition(); TODO
        player.setMove(false);
        battleGround.setPokemon(dangerZone.getPokemon());
        battleGround.draw();
    }

    public DangerZone[] getDangerZones() {
        return this.dangerZones;
    }

    public Solid[] getSolids() {
        return this.solids;
    }
}
