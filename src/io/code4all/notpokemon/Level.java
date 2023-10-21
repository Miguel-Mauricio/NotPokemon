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
    private Cosmetics[] cosmetics;
    private Elon[] elonBoss;
    BattleGround battleGround;

    private LinkedList<Pokemon> pokemons;

    public Level(Player player, LinkedList<Pokemon> pokemons, PopupMessage popupMessage) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        this.player = player;
        this.pokemons = pokemons;
        this.popupMessage = popupMessage;
        solids = new Solid[15];
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

        cosmetics = new Cosmetics[3];
        cosmetics[0] = new GrassCosmetics(55,530);
        cosmetics[1] = new WaterCosmetics(860,45);
        cosmetics[2] = new LavaCosmetics(1050,350);

        elonBoss = new Elon[1];
        elonBoss[0] = new Elon();

        LinkedList<Pokemon> pokemonsLevel1 = new LinkedList<>();
        LinkedList<Pokemon> pokemonsLevel2 = new LinkedList<>();
        LinkedList<Pokemon> pokemonsLevel3 = new LinkedList<>();
        for(Pokemon p : pokemons)
            if(p.getLevel() == 1)
                pokemonsLevel1.add(p);
            else if(p.getLevel() == 2)
                pokemonsLevel2.add(p);
            else
                pokemonsLevel3.add(p);

        dangerZones = new DangerZone[4];
        dangerZones[0] = new HighGrass(75, 700, pokemonsLevel1);
        dangerZones[1] = new HighGrass(240,660, pokemonsLevel1);
        dangerZones[2] = new Water(860, 45, pokemonsLevel1);
        dangerZones[3] = new Lava(1050, 350, pokemonsLevel1);

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
                player.getPokemon().reanimate();
                battleGround.cleanTables();
                battleGround.setIsReady(false); // bad variable name :) sy guys
                player.setMove(true);
                for (DangerZone d : dangerZones)
                    if (player.checkPlayerPositionWithOtherObj(player.getPicture().getX(), player.getPicture().getY(), d)) {
                        // can do another number to arrange better position after exiting dangerzone
                        player.setPosition(d.getPicture().getX() + d.getPicture().getWidth() / 2, d.getPicture().getMaxY() + 10);
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
