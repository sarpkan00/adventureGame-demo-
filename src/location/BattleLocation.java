package location;

import gameUtility.Player;
import monsters.Obstacle;

import java.util.Locale;
import java.util.Random;

public abstract class BattleLocation extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLocation(Player player, String name, Obstacle obstacle, String award,int maxObstacle) {
        super(player,name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("Şuan Buradasınız: " + this.getName());
        System.out.println("Dikkatli Ol!!! Burada " + obsNumber + " tane " + this.getObstacle().getName() + " Yaşıyor");
        System.out.println("Savaşmak için <S>, Kaçmak için <K>");
        String selectCase = scanner.nextLine().toUpperCase(Locale.ROOT);

        if(selectCase.equals("S") && combat(obsNumber)){
            System.out.println(getName() + " Tüm düşmanları yendiniz...");
                return true;
        }
        if(getPlayer().getHealth() <= 0){
            System.out.println("Öldünüz");
            return false;
        }

        return true;
    }

    public boolean combat(int obsNumber){

        for(int i= 0; i<= obsNumber; i++){
            getObstacle().setHealt(getObstacle().getOrginalHealt());
            playerStats();
            obstacleStats(i);
            while (getPlayer().getHealth() > 0 && getObstacle().getHealt() > 0){
                System.out.println("Vur<V> yada Kaç<K>");
                String selectCombat = scanner.nextLine().toUpperCase(Locale.ROOT);
                if(selectCombat.equals("V")){
                    System.out.println("Siz vurdunuz !!");
                    obstacle.setHealt(getObstacle().getHealt() - getPlayer().getTotalDamage());
                    afterHit();
                    if(getObstacle().getHealt() > 0){
                        System.out.println(" Canavar Size vurdu !");
                        int obstacleDamage = getObstacle().getDamage() - getPlayer().getInventory().getArmor().getBlock();
                        if(obstacleDamage < 0){
                            obstacleDamage = 0;
                        }
                        getPlayer().setHealth(getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                    }
                }
                else {
                    return false;
                }
            }
            if(getObstacle().getHealt() < getPlayer().getHealth()){
                System.out.println("Düşmanı Yendiniz !!!");
                System.out.println(getObstacle().getAward() + " para kazandınız");
                getPlayer().setMoney(getPlayer().getMoney() + getObstacle().getAward());
                System.out.println("Paranız : " + getPlayer().getMoney());
            }
        }

        return false;
    }

    public void afterHit(){
        System.out.println("Canınız : " + getPlayer().getHealth());
        System.out.println(getObstacle().getName() + " Canı " + getObstacle().getHealt());
        System.out.println();
    }

    public void playerStats(){
        System.out.println("Oyuncu Değerleri");
        System.out.println("-------------------------");
        System.out.println("Sağlık : " +this.getPlayer().getHealth());
        System.out.println("Silah : " + getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh : " + getPlayer().getInventory().getArmor().getName());
        System.out.println("Blocklama : " + getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Hasar : " + this.getPlayer().getTotalDamage());
        System.out.println("Para : " + this.getPlayer().getMoney());
        System.out.println("-------------------------");

    }

    public void obstacleStats(int i){
        System.out.println(i + "." + getObstacle().getName() + " Değerleri");
        System.out.println("-------------------------");
        System.out.println("Sağlık : " + getObstacle().getHealt());
        System.out.println("Hasar : " + getObstacle().getDamage());
        System.out.println("Para : " + getObstacle().getAward());

    }

    public int randomObstacleNumber(){
        Random random = new Random();
        return random.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
