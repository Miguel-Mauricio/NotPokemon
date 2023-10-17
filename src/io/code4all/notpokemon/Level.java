package io.code4all.notpokemon;

import io.code4all.notpokemon.game_objects.*;
import io.code4all.notpokemon.game_objects.pokemon.Pokemon;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class Level {
    private Player player;
    private Solid[] solids;
    private DangerZone[] dangerZones;
    private LinkedList<Pokemon> pokemons;

    public Level(Player player, LinkedList<Pokemon> pokemons) {
        this.player = player;
        this.pokemons = pokemons;
        solids = new Solid[6];
        solids[0] = new Rock(100, 50);
        solids[1] = new Rock(300, 400);
        solids[2] = new Tree(300, 300);
        solids[3] = new Tree(400, 200);
        solids[4] = new House(150, 200);
        solids[5] = new House(70, 300);

        dangerZones = new DangerZone[3];
        dangerZones[0] = new HighGrass(300, 50, pokemons);
        dangerZones[1] = new HighGrass(100, 70, pokemons);
        dangerZones[2] = new HighGrass(300, 160, pokemons);
    }

    public void start() {
        System.out.println(player.getPokemon());
        while (!player.getPokemon().isDead()) {
            // TODO
        }
    }


    public void startBattle() {
        // Checking witch dangerZone has player
        DangerZone dangerZone = null;
        for (DangerZone d : dangerZones)
            if (player.checkPlayerPositionWithOtherObj(player.getPicture().getX(), player.getPicture().getY(), d))
                dangerZone = d;
        // playTransition(); TODO

        BattleGround battleGround = new BattleGround(player.getPokemon(), dangerZone.getPokemon());
        battleGround.start();
        //battleGround.cleanGameObjects();

        // Reanimate dead or not Pokemon
        dangerZone.getPokemon().reanimate();

    }

    public DangerZone[] getDangerZones() {
        return this.dangerZones;
    }

    public Solid[] getSolids() {
        return this.solids;
    }
}
