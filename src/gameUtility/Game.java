package gameUtility;

import location.Cave;
import location.Forest;
import location.Location;
import location.SafeHouse;

import java.util.Scanner;
import gameUtility.Player;

public class Game {
    private Scanner scanner = new Scanner(System.in);


    public void start(){
        System.out.println("Macera Oyununa Hoşgeldiniz!!");
        System.out.println("Lütfen Bir İsim giriniz: ");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);
        System.out.println("Sevgili " + player.getName() + " karanlık adaya hoşgeldin!!");
        System.out.println("BURDA YAŞANANLARIN HEPSİ GERÇEK!!!");
        System.out.println("Lütfen Bir Karekter Seçiniz");
        player.selectChar();

        Location location = null;
        while(true){
            player.printPlayerInfo();
            System.out.println("######### Bölgeler  #########");
            System.out.println("1- Güvenli Ev --> Burası Sizin için güvenli bir ev, düşman yok!!!");
            System.out.println("2- Dükkan --> Silah ve ya Zırh satın alabilirsiniz");
            System.out.println("3- Mağaraya git, Ödül <Yemek>, dikkatli ol zombi çıkabilir!!!!");
            System.out.println("4- Ormana git, Ödül <Odun>, dikkatli ol vampir çıkabilir!!!!");
            System.out.println("5- Nehire git, Ödül <Su>, dikkatli ol ayı çıkabilir!!!!");
            System.out.println("0- Çıkış Yap --> Oyunu Sonlandır");
            System.out.println("Lütfen Gitmek İstediğiniz Bölgeyi Seçiniz");
            int selectLocation = scanner.nextInt();
            switch (selectLocation){
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new Cave(player);
                    break;
                default:
                    System.out.println("Geçersiz işlem. KORKMA!!!");;

            }
            if(location == null){
                System.out.println("Bu Karanlık Adadan Çabuk Vazgeçtin!! :)))");
                break;
            }
            if(!location.onLocation()){
                System.out.println("GAME OVER!!");
                break;
            }
        }


    }
}
