package location;

import gameUtility.Player;
import location.BattleLocation;
import monsters.Zombie;

public class Cave extends BattleLocation {

    public Cave(Player player) {
        super(player, "Mağara", new Zombie(),"Food",3);
    }
}
