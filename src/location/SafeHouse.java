package location;

import gameUtility.Player;

public class SafeHouse extends NomalLocation {
    public SafeHouse(Player player){

        super(player,"Güvenli Ev");
    }

    @Override
    public boolean onLocation(){
        System.out.println("Güvenli Evdesiniz");
        System.out.println("Canınız Yenilendi");
        getPlayer().setHealth(getPlayer().getOrginalHealt());
        return true;
    }
}
