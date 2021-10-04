package location;

import gameUtility.Player;
import monsters.Bear;
import monsters.Obstacle;

public class River extends BattleLocation{
    public River(Player player) {
        super(player,"Nehir",new Bear(),"water",2);
    }
}
