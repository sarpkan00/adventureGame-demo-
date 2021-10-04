package location;

import gameUtility.Player;
import location.Location;

public abstract class NomalLocation extends Location {

    public NomalLocation(Player player, String name){
        super(player,name);
    }
    @Override
    public boolean onLocation() {
        return true;
    }
}
