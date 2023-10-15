package io.code4all.notpokemon;

import io.code4all.notpokemon.game_objects.*;

public class Level {
    private Player player;
    private Solid[] solids;
    private DangerZone[] dangerZones;

    public Level(Player player) {
        this.player = player;
        solids = new Solid[6];
        solids[0] = new Rock(100, 50);
        solids[1] = new Rock(300, 400);
        solids[2] = new Tree(300, 300);
        solids[3] = new Tree(400, 200);
        solids[4] = new House(150, 200);
        solids[5] = new House(70, 300);

        dangerZones = new DangerZone[3];
        dangerZones[0] = new HighGrass(300, 50);
        dangerZones[1] = new HighGrass(100, 70);
        dangerZones[2] = new HighGrass(300, 160);

    }

    public void checkColisions(){
        // TODO
    }

    public void startBattle(){
      // TODO
        System.out.println("STARTING BATTLE!!!!");
    }

    public DangerZone[] getDangerZones(){
        return this.dangerZones;
    }

    public Solid[] getSolids(){
        return this.solids;
    }
}
