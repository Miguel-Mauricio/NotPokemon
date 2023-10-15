package io.code4all.notpokemon;

import io.code4all.notpokemon.game_objects.Solid;
import io.code4all.notpokemon.game_objects.Rock;
import io.code4all.notpokemon.game_objects.DangerZone;

public class Level {
    private Player player;
    Solid[] solids;
    DangerZone[] dangerZones;

    public Level(Player player) {
        this.player = player;
        solids = new Solid[1];
        Rock rock = new Rock();
        solids[0] = rock;

    }

    public void checkColisions(){
        // TODO
    }

    public void startBattle(){
      // TODO
    }
}
