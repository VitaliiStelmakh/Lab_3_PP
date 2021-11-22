package Controller;

import BattleLogger.BattleLog;
import Model.BattleDroid;
import Model.Droid;
import Model.DroidDefender;
import Model.Droideka;

import java.util.Random;
import java.util.Scanner;

public class Battle1vs1 extends Battle {
    public static final Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

   Droid attacker = null;
   Droid defender = null;
   Droid hero=null;
   Droid enemy=null;
    public void Start() {
        int r = random.nextInt(3) + 1;
        System.out.println("Choose droid (1 - BattleDroid, 2 - Droideka, 3 - DroidDefender) :");
        int choose=0;
        while (true) {
            choose = scanner.nextInt();
            if(choose==1 ||choose==2||choose==3)
            {
                hero = ChooseDroid(choose, hero);
                enemy = ChooseDroid(r, enemy);
                Battle(hero, enemy);
                break;
            }
            else
            {
                System.out.println("Please choose droid from list");
            }
        }
    }
    public Droid ChooseDroid(int choose, Droid droid)
    {
        switch (choose) {
            case 1: {
                droid = new BattleDroid();
                break;
            }
            case 2: {
                droid = new Droideka();
                break;
            }
            case 3: {
                droid = new DroidDefender();
                break;
            }
        }

        return droid;
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
