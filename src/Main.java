import java.util.Random;
public class Main {

    static int bossHealth = 1500;
    static int bossDamage = 50;
    static String bossDefence;


    static int[] herouthHealth = {100, 200, 150, 100, 100, 150, 200, 300};
    static int[] herouthDamage = {30, 10, 20, 0, 10, 0, 15, 5};
    static String[] herouseAtachType = {"Phisical", "Magical", "Piersing", "Medic", "Lucky", "Witcher", "Thor", "Golem"};


    static int raoundNumber = 0;


    public static void main(String[] args) {
        showStatistics();
        while (!isGameOver()) {
            playRound();
        }

    }

    public static void playRound() {

        raoundNumber++;
        chooseBossDefense();
        bossAtak();
        herousAtak();
        showStatistics();
        medicHill();

    }

    public static boolean isGameOver() {

        if (bossHealth <= 0) {
            System.out.println("Herous won");
            return true;
        }


        boolean herousDeath = true;

        for (int i = 0; i < herouthHealth[i]; i++) {

            if (herouthHealth[i] > 0) {
                herousDeath = false;
                break;
            }

        }

        if (herousDeath) {
            System.out.println("Boss won");
        }

        return herousDeath;

    }

    public static void chooseBossDefense() {

        Random random = new Random();
        int randomNumber = random.nextInt(herouseAtachType.length);
        bossDefence = herouseAtachType[randomNumber];

    }


    public static void bossAtak() {

        int howMachGolemGetDamage;
        int numberOfAtachBoss = 0;
        int damageOfBoss = bossDamage / 5;
        int afterDamageOfboss = bossDamage - damageOfBoss;


        for (int i = 0; i < herouthHealth.length; i++) {

            if (herouseAtachType[i] == "Lucky" && lucky()) {
                continue;
            } else if (herouseAtachType[i] != "Golem") {
                herouthHealth[i] = herouthHealth[i] - afterDamageOfboss;
                numberOfAtachBoss++;

            } else {
                howMachGolemGetDamage = numberOfAtachBoss * damageOfBoss;
                herouthHealth[7] = herouthHealth[7] - howMachGolemGetDamage;
            }

            if (herouthHealth[i] < 0 && herouthHealth[5] > 0) {
                herouthHealth[i] = herouthHealth[5] + herouthHealth[i];
                herouthHealth[5] = 0;
            } else if (herouthHealth[i] < 0) {
                herouthHealth[i] = 0;
            }
        }

    }

    public static void herousAtak() {

        for (int i = 0; i < herouthDamage.length; i++) {

            if (herouseAtachType[i] == bossDefence) {
                int damage = herouthDamage[i];
                Random random = new Random();
                int randomNumber = random.nextInt(2) + 2;
                herouthDamage[i] = damage * randomNumber;
                bossHealth = bossHealth - damage;
            }


            bossHealth = bossHealth - herouthDamage[i];
            if (bossHealth < 0) {
                bossHealth = 0;

            }

        }

    }

      //способность медика в том что он может лечить других игроков, но не может атаковать и воскрешать тоже не может он, лечит только одного у которого жизнь меньше 100
    public static void medicHill() {
        for (int i = 0; i < herouthHealth[i]; i++) {
            Random random = new Random();
            if (herouthHealth[3] != 0) {
                if (herouthHealth[i] < 100 && herouthHealth[i] > 0 && herouseAtachType[i] != "Medic") {
                    int hill = 5;
                    int randomNumber = random.nextInt(10) + 2;
                    int howMuchHil = hill * randomNumber;
                    herouthHealth[i] = herouthHealth[i] + howMuchHil;
                    System.out.println("Medic Hilt: " + herouseAtachType[i] + " on " + howMuchHil);
                    break;

                }
            }
        }
    }

    public static boolean lucky() {

        boolean luckyed;

        Random random = new Random();

        luckyed = random.nextBoolean();

        return luckyed;

    }

    public static boolean thorAtack() {

        boolean thorAtackedSeccesfull;

        Random random = new Random();

        thorAtackedSeccesfull = random.nextBoolean();

        return thorAtackedSeccesfull;

    }


    public static void showStatistics() {

        System.out.println("Round number: " + raoundNumber + "--------------------");

        String defence;


        System.out.println("Boss health:" + bossHealth + " damage:" + bossDamage + " defence:" + (bossDefence == null ? "No defence" : bossDefence));

        for (int i = 0; i < herouthHealth.length; i++) {
            System.out.println(herouseAtachType[i] + " health:" + herouthHealth[i] + " damage:" + herouthDamage[i]);
        }

    }

}