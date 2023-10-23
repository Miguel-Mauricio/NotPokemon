package io.code4all.notpokemon;

import io.code4all.notpokemon.game_objects.*;
import io.code4all.notpokemon.game_objects.cosmetics.*;
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
    private Elon[] elonBoss;
    BattleGround battleGround;
    private Pokemon bigEnemy;
    private LinkedList<Pokemon> pokemons;

    public Level(Player player, LinkedList<Pokemon> pokemons, PopupMessage popupMessage) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        this.player = player;
        this.popupMessage = popupMessage;
        this.pokemons = pokemons;

        cosmetics = new Cosmetics[14];
        cosmetics[0] = new GrassCosmetics(55, 530);
        cosmetics[1] = new WaterCosmetics(860, 45);
        cosmetics[2] = new LavaCosmetics(1050, 350);
        cosmetics[3] = new Flowers(Game.PADDING + 300, Game.PADDING + 450);
        cosmetics[4] = new Flowers(Game.PADDING, Game.GAME_HEIGHT - Game.PADDING - 250);
        cosmetics[5] = new Flowers(Game.PADDING, 630);
        cosmetics[6] = new Flowers(Game.PADDING, 680);
        cosmetics[7] = new Flowers(800, Game.PADDING);
        cosmetics[8] = new Flowers(900, Game.PADDING);
        cosmetics[9] = new Flowers(1000, Game.PADDING);
        cosmetics[10] = new Flowers(1050, 50);
        cosmetics[11] = new Flowers(1050, 100);
        cosmetics[12] = new Flowers(1050, 150);
        cosmetics[13] = new Flowers(1050, 200);

        solids = new Solid[16];
        solids[0] = new Tree(200, 40);
        solids[1] = new Tree(100, 40);
        solids[2] = new Tree(50, 100);
        solids[3] = new Tree(60, 200);
        solids[4] = new Tree(110, 300);
        solids[5] = new Tree(160, 430);
        solids[6] = new Tree(600, 300);
        solids[7] = new Tree(550, 150);
        solids[8] = new Tree(340, 120);
        solids[9] = new Tree(400, 370);
        solids[10] = new Tree(750, 470);
        solids[11] = new Tree(800, 370);
        solids[12] = new Tree(500, 630);
        solids[13] = new Tree(700, 700);
        solids[14] = new Tree(1050, 650);
        solids[15] = new Dog(90, 150);

        elonBoss = new Elon[1];
        elonBoss[0] = new Elon();
        bigEnemy = new BigEnemy();

        dangerZones = new DangerZone[4];
        dangerZones[0] = new HighGrass(75, 700, pokemons);
        dangerZones[1] = new HighGrass(240, 660, pokemons);
        dangerZones[2] = new Water(860, 45, pokemons);
        dangerZones[3] = new Lava(1050, 350, pokemons);

        battleGround = new BattleGround(player.getPokemon(), pokemons.get(0));

        BackgroundMusic.playMusic();
    }

    public void start() {
        while (true) {
            System.out.println(player.getPokemon());
            if (bigEnemy.getHealth() <= 0) {
                Background gameOverWin = new Background(new Rectangle(Game.PADDING, Game.PADDING, Game.GAME_WIDTH, Game.GAME_HEIGHT), new Picture(Game.PADDING, Game.PADDING, "gameOverWin.png"));
                gameOverWin.draw();
                return;
            }
            if (player.getPokemon().isDead()) {
                System.out.println("GAME OVER BABY!!!");
                Background gameOver = new Background(new Rectangle(Game.PADDING, Game.PADDING, Game.GAME_WIDTH, Game.GAME_HEIGHT), new Picture(Game.PADDING, Game.PADDING, "gameOver.png"));
                gameOver.draw();
                return  ;
            }
            if (battleGround.getPokemon().getHealth() <= 0) {
                System.out.println("Resetting battleground");
                battleGround.getPokemon().reanimate();
                player.getPokemon().reanimate();
                battleGround.cleanTables();
                battleGround.setIsReady(false); // bad variable name :) sy guys
                player.setMove(true);
                player.getPokemon().gainXP(3);
                for (DangerZone d : dangerZones)
                    if (player.checkPlayerPositionWithOtherObj(player.getPicture().getX(), player.getPicture().getY(), d)) {
                        // can do another number to arrange better position after exiting dangerzone
                        player.setPosition(d.getPicture().getMaxX() + 20, d.getPicture().getY() + d.getPicture().getHeight() / 2);
                    }


                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            while (!player.getPokemon().isDead() && !battleGround.getPokemon().isDead()) {
                if (!battleGround.isReady() && player.checkPlayerPositionWithOtherObj(player.getPicture().getMaxX(), player.getPicture().getMaxY(), elonBoss[0])) {
                    battleGround.setIsReady(true);
                    startBattle(bigEnemy);
                }
                if (!battleGround.isReady())
                    for (DangerZone d : dangerZones) {
                        System.out.println("checking");
                        if (player.checkPlayerPositionWithOtherObj(player.getPicture().getX(), player.getPicture().getY(), d) && Math.random() * 10 > 8) {
                            battleGround.setIsReady(true);
                            startBattle(d.getPokemon());
                            d.setNewPokemon(d.getPokemon().getLevel(), pokemons);
                        }
                    }
                else{
                    battleGround.fight(popupMessage);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }
            }
        }
    }


    public void startBattle(Pokemon p) {
        // playTransition(); TODO
        player.setMove(false);
        player.getPokemon().setSpecial(true);
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
