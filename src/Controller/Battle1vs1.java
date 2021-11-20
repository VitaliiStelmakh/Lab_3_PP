package Controller;

import BattleLogger.BattleLog;
import Model.BattleDroid;
import Model.Droid;
import Model.Droideka;

import java.util.Random;
import java.util.Scanner;

public class Battle1vs1 extends Battle {
    public static final Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

   Droid attacker = null;
   Droid defender = null;

    public void Start() {
        int r =1; //random.nextInt(1) + 1;
        System.out.println("Choose a droid (1 - Warrior, 2 - Rogue, 3 - Mage) :");
      //  int choose = scanner.nextInt();
        Droid hero = new BattleDroid();
        hero.setName("Hero " + hero.getName());
        Droid enemy = new Droideka();
        enemy.setName("Enemy "+ enemy.getName());
        Battle(hero, enemy);
    }


    public void Battle(Droid hero, Droid enemy) {
        BattleLog logger = new BattleLog();
        logger.ClearSessionLog();

        System.out.println(hero.getName() + " health = " + hero.getHealth() +" "+
                enemy.getName() + " health = " + enemy.getHealth());
        System.out.println("--------------------------------------------------------------------------------------\n");

        logger.AddLog(hero.getName() + " health = " + hero.getHealth() +" "+
                enemy.getName() + " health = " + enemy.getHealth());
        logger.AddSeparator();

        boolean i = random.nextBoolean();

        while (true) {

            if (i)
                attacker =hero;
            else
                attacker =enemy;
            i=!i;

            if(attacker == hero)
            {
                defender = hero;
                attacker = enemy;
                System.out.println("Enemy attack");
            }
            else
            {
                attacker = hero;
                defender = enemy;
                System.out.println("Hero attack");
            }

                attacker.Attack();
                defender.Defense(attacker.getDamage());
                System.out.println("Attacker " + attacker.getName() + " damaged " + attacker.getDamage() + " Defender " + defender.getName());
                logger.AddLog("Attacker " + attacker.getName() + " damaged " + attacker.getDamage() + " Defender " + defender.getName());


                if (defender.getHealth() <= 0) {
                    System.out.println("Attacker " + attacker.getName() + " with " + attacker.getHealth() + " health" +
                            " winner of this battle!");
                    logger.AddLog("Attacker " + attacker.getName() + " with " + attacker.getHealth() + " health" +
                            " winner of this battle!");
                    break;
                } else {
                    System.out.println("Attacker health = " + attacker.getHealth() +" energy = "+attacker.getEnergy()+  " Defender health = " + defender.getHealth());
                    logger.AddLog("Attacker health = " + attacker.getHealth() + " Defender health = " + defender.getHealth());
                }

                System.out.println("----------------------------------------------------------------------------------\n");
                logger.AddSeparator();
        }
    }
}
