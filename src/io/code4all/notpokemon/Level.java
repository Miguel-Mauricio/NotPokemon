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
        solids = new Solid[2];
        solids[0] = new Rock(100, 50);
        solids[1] = new Rock(300, 400);

    }

    public void checkColisions(){
        // TODO
    }

    public void startBattle(){
      // TODO
    }
}
