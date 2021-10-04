package gameUtility;

import location.NomalLocation;

public class ToolStore extends NomalLocation {
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        boolean showMenu = true;
        System.out.println("---------Mağazaya Hoşgeldiniz!!---------");
        while (showMenu){
            System.out.println("1 - Silahlar");
            System.out.println("2 - Zırhlar");
            System.out.println("3 - Çıkış Yap");
            int selectCase = scanner.nextInt();
            while (selectCase < 1 || selectCase >3){
                System.out.println("Geçersiz değer , tekrar giriniz");
                selectCase = scanner.nextInt();
            }
            switch (selectCase){
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Bir daha bekleriz");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }
    public void printWeapon(){
        System.out.println("------- Silahlar -------");
       for(Weapon weapon : Weapon.weapons()){
           System.out.println( weapon.getId() + " - " +
                   weapon.getName()+ " Para : " + weapon.getPrice() +
                   " Hasar: " + weapon.getDamage());
       }
        System.out.println("0 - Çıkış Yap");

    }

    public void buyWeapon(){

        System.out.println("Bir Silah Seçiniz");
        int selectWeaponId = scanner.nextInt();
        while (selectWeaponId < 0 || selectWeaponId >  Weapon.weapons().length){
            System.out.println("Geçersiz değer , tekrar giriniz");
            selectWeaponId = scanner.nextInt();
        }

        if(selectWeaponId !=0){
            Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeaponId);

            if(selectedWeapon != null){
                if(selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Yeterli Paranız Bulunmamaktadır");
                }else {
                    //Satın almanın gerçekleştiği yer
                    System.out.println(selectedWeapon.getName() + " Silahını satın aldınız ");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan Paranız : " + this.getPlayer().getMoney());
                    System.out.println("Önceki Silahınız : " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Yeni Silahınız : " + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }

    }



    public void printArmor(){
        System.out.println("------- Zırhlar -------");
        for(Armor armor : Armor.armors()){
            System.out.println(armor.getId() + " - " +
                    armor.getName() + " Fiyat : " +
                    armor.getPrice() + " Zırh Değeri : " +
                    armor.getBlock());
        }
        System.out.println("0 - Çıkış Yap");
    }

    public void buyArmor(){
        System.out.println("Bir Zırh Seçiniz");
        int selectArmorId = scanner.nextInt();
        while (selectArmorId < 0 || selectArmorId >  Armor.armors().length){
            System.out.println("Geçersiz değer , tekrar giriniz");
            selectArmorId = scanner.nextInt();
        }
         if(selectArmorId != 0){
             Armor selectedArmor = Armor.getArmorObjById(selectArmorId);

             if(selectedArmor != null){
                 if (selectedArmor.getPrice() > this.getPlayer().getMoney()){
                     System.out.println("Yeterli Paranız Bulunmamaktadır !!");
                 }else{
                     System.out.println(selectedArmor.getName() + " Zırhını Satın Aldınız");
                     int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                     this.getPlayer().setMoney(balance);
                     this.getPlayer().getInventory().setArmor(selectedArmor);
                     System.out.println("Kalan Paranız : " + this.getPlayer().getMoney());
                 }
             }
         }

    }
}
