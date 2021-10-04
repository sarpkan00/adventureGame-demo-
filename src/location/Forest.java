package location;

import gameUtility.Player;
import monsters.Obstacle;
import monsters.Vampire;

public class Forest extends BattleLocation {
    public Forest(Player player) {
        super(player,"Orman",new Vampire(),"firewood",3);
    }
}
