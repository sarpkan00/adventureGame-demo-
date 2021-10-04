package gameUtility;

import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;
    private Scanner scanner = new Scanner(System.in);
    private Inventory inventory;
    private int orginalHealt;



    public Player(String name){
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar(){
       ;

        GameCharacter[] characters = { new Samurai(), new Archer(),new Knight()};

        System.out.println("----------------------------------------------------------------------");
        for (GameCharacter gameCharacter: characters) {
            System.out.println("ID : " +gameCharacter.getId() +
                    "\t Karekter :" + gameCharacter.getName() +
                    "\t Hasar: " + gameCharacter.getDamage()+
                    "\t Sağlık: " +gameCharacter.getHealt() +
                    "\t Para: " + gameCharacter.getMoney());
        }
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Lütfen Bir Karekter Seçiniz: ");
        int selectChar = scanner.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("Karakter : " +this.getCharName() +
                " Hasar : " +this.getDamage() +
                " Sağlık :" + this.getHealth() +
                " Para : " + this.getMoney() );


    }

    public void selectLocation(){

    }

    public void initPlayer(GameCharacter gameCharacter){
        this.setDamage(gameCharacter.getDamage());
        this.setHealth(gameCharacter.getHealt());
        this.setOrginalHealt(gameCharacter.getHealt());
        this.setMoney(gameCharacter.getMoney());
        this.setCharName(gameCharacter.getName());
    }

    public void printPlayerInfo(){
        System.out.println(
                " Silah : " + this.getInventory().getWeapon().getName() +
                " Zırh : " +this.getInventory().getArmor().getName() +
                " Blocklama : " +this.getInventory().getArmor().getBlock() +
                        " Hasar : " +this.getTotalDamage() + " Sağlık :" + this.getHealth() +
                " Para : " + this.getMoney());
    }
    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOrginalHealt() {
        return orginalHealt;
    }

    public void setOrginalHealt(int orginalHealt) {
        this.orginalHealt = orginalHealt;
    }
}
