package io.code4all.notpokemon;

import io.code4all.notpokemon.game_objects.*;
import io.code4all.notpokemon.game_objects.pokemon.BigEnemy;
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
    private Cosmetics[] cosmetics;
    private BattleGround battleGround;
    private GameObject elon;
    private Pokemon bigEnemy;

    public Level(Player player, LinkedList<Pokemon> pokemons, PopupMessage popupMessage) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        this.player = player;
        this.popupMessage = popupMessage;
        elon = new Elon();
        bigEnemy = new BigEnemy();
        solids = new Solid[1];
        solids[0] = new Tree(200, 50);
       /* solids[1] = new Rock(300, 400);
        solids[2] = new Tree(500, 300);
        solids[3] = new Tree(400, 200);
        solids[4] = new House(650, 200);
        solids[5] = new House(600, 300);*/

        cosmetics = new Cosmetics[2];
        cosmetics[0] = new GrassCosmetics(55, 530);


        dangerZones = new DangerZone[3];
        LinkedList<Pokemon> pokemonsLevel1 = new LinkedList<>();
        LinkedList<Pokemon> pokemonsLevel2 = new LinkedList<>();
        LinkedList<Pokemon> pokemonsLevel3 = new LinkedList<>();
        for (Pokemon p : pokemons)
            if (p.getLevel() == 1)
                pokemonsLevel1.add(p);
            else if (p.getLevel() == 2)
                pokemonsLevel2.add(p);
            else
                pokemonsLevel3.add(p);
        dangerZones[0] = new HighGrass(60, 650, pokemonsLevel1);
        dangerZones[1] = new HighGrass(200, 600, pokemonsLevel1);
        dangerZones[2] = new HighGrass(600, 160, pokemonsLevel1);

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
                battleGround.cleanTables();
                battleGround.setIsReady(false); // bad variable name :) sy guys
                player.setMove(true);
                // Moving player out of dangerzone
                for (DangerZone d : dangerZones)
                    if (player.checkPlayerPositionWithOtherObj(player.getPicture().getX(), player.getPicture().getY(), d)) {
                        // can do another number to arrange better position after exiting dangerzone
                        player.setPosition(d.getPicture().getX() + d.getPicture().getWidth() / 2, d.getPicture().getMaxY() + 10);
                    }
                player.getPokemon().reanimate();
                player.getPokemon().gainXP(20);
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
                        if (player.checkPlayerPositionWithOtherObj(player.getPicture().getX(), player.getPicture().getY(), d) && Math.random() * 10 > 6) {
                            battleGround.setIsReady(true);
                            startBattle(d.getPokemon());
                        } else if (player.checkPlayerPositionWithOtherObj(player.getPicture().getMaxX(), player.getPicture().getMaxY(), elon)) {
                            battleGround.setIsReady(true);
                            startBattle(bigEnemy);
                        }
                    }
                else
                    battleGround.fight(popupMessage);
            }
        }
    }

    public void startBattle(Pokemon p){
        // play transition() TODO
        player.setMove(false);
        battleGround.setPokemon(p);
        battleGround.draw();
    }

    public DangerZone[] getDangerZones() {
        return this.dangerZones;
    }

    public Solid[] getSolids() {
        return this.solids;
    }
}
