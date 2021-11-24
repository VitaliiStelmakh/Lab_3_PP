package Controller;

import BattleLogger.BattleLog;
import Model.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BattleTeamVsTeam extends Battle{
    public static final Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);


    Droid hero=null;
    Droid enemy=null;
    
    ArrayList<Droid> heroTeam = new ArrayList<Droid>();
    ArrayList<Droid> enemyTeam = new ArrayList<Droid>();
    ArrayList<Droid> attacker = null;
    ArrayList<Droid> defender = null;
    @Override
    public void Start() {

        int choose=0;
        for (int i=0; i<3; i++ ){
        System.out.println("Choose droid (1 - BattleDroid, 2 - Droideka, 3 - DroidDefender, 4 - DroidMedic) :");
        while (true) {
            int r = random.nextInt(4) + 1;
            choose = scanner.nextInt();
            if(choose==1 ||choose==2||choose==3||choose==4)
            {
                hero = ChooseDroid(choose, hero);
                heroTeam.add(hero);
                enemy = ChooseDroid(r, enemy);
                enemyTeam.add(enemy);
                break;
            }
            else
            {
                System.out.println("Please choose droid from list");
            }
        }
        }
        Battle(heroTeam, enemyTeam);
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
                droid = new ArmorDroid();
                break;
            }
            case 4:{
                droid = new DroidMedic();
                break;
            }
        }
        return droid;
    }

    public void Battle(ArrayList<Droid> heroTeam, ArrayList<Droid> enemyTeam) {
        int rh, re;
        BattleLog logger = new BattleLog();
        logger.ClearSessionLog();


        System.out.println("Hero team\t\t\t\t\t\t\t\t\t\t\tEnemy team");
        System.out.println("--------------------------------------------------------------------------------------\n");
        logger.AddLog("Hero team\t\t\t\t\t\t\t\t\t\t\tEnemy team");
        logger.AddSeparator();
        for (int i = 0; i < 3; i++) {
            System.out.println("Hero " + heroTeam.get(i).getName() + " health = " + heroTeam.get(i).getHealth() + " energy = " + heroTeam.get(i).getEnergy()+
                    "\t\tEnemy " + enemyTeam.get(i).getName() + " health = " + enemyTeam.get(i).getHealth()+ " energy = " + heroTeam.get(i).getEnergy());
            logger.AddLog("Hero " + heroTeam.get(i).getName() + " health = " + heroTeam.get(i).getHealth() + " energy = " + heroTeam.get(i).getEnergy()+
                    "\t\tEnemy " + enemyTeam.get(i).getName() + " health = " + enemyTeam.get(i).getHealth()+ " energy = " + heroTeam.get(i).getEnergy());
        }

        System.out.println("--------------------------------------------------------------------------------------\n");
        logger.AddSeparator();


        boolean j = random.nextBoolean();

        while (true) {

            if (j)
                attacker =heroTeam;
            else
                attacker =enemyTeam;
            j=!j;

            if(attacker == heroTeam)
            {
                defender = heroTeam;
                attacker = enemyTeam;
                System.out.println("enemyTeam attack");
            }
            else
            {
                attacker = heroTeam;
                defender = enemyTeam;
                System.out.println("heroTeam attack");
            }

            rh = random.nextInt(attacker.size());
            re = random.nextInt(defender.size());

            if (attacker.get(rh).getClass()==DroidMedic.class){
               int rm = random.nextInt(attacker.size());
                attacker.get(rh).Attack();
                attacker.get(rm).Defense(attacker.get(rh).getDamage());

                System.out.println("Attacker " + attacker.get(rh).getName() + " heal teammate " + attacker.get(rm).getName() +" on "+ attacker.get(rh).getDamage());
                System.out.println("--------------------------------------------------------------------------------------\n");
                logger.AddLog("Attacker " + attacker.get(rh).getName() + " heal teammate " + attacker.get(rm).getName() +" on "+ attacker.get(rh).getDamage());
                logger.AddSeparator();
            }

            else {
                attacker.get(rh).Attack();
                defender.get(re).Defense(attacker.get(rh).getDamage());

                System.out.println("Attacker " + attacker.get(rh).getName() + " damaged " + attacker.get(rh).getDamage() +
                        " Defender " + defender.get(re).getName());
                logger.AddLog("Attacker " + attacker.get(rh).getName() + " damaged " + attacker.get(rh).getDamage() +
                        " Defender " + defender.get(re).getName());

                System.out.println();
                logger.AddLog("\n");

                if (defender.get(re).getHealth() <= 0) {
                    System.out.println("Attacker " + attacker.get(rh).getName() + " killed " +
                            " Defender " + defender.get(re).getName());
                    logger.AddLog("Attacker " + attacker.get(rh).getName() + " killed " +
                            " Defender " + defender.get(re).getName());
                    defender.remove(re);
                    System.out.println();
                    logger.AddLog("\n");
                }

                for (int i = 0; i < attacker.size(); i++) {
                    System.out.println("Attacker " + attacker.get(i).getName() + " health = " + attacker.get(i).getHealth() + " energy = " + attacker.get(i).getEnergy());
                    logger.AddLog("Attacker " + attacker.get(i).getName() + " health = " + attacker.get(i).getHealth() + " energy = " + attacker.get(i).getEnergy());
                }
                System.out.println();
                logger.AddLog("\n");
                for (int i = 0; i < defender.size(); i++) {
                    System.out.println("Defender " + defender.get(i).getName() + " health = " + defender.get(i).getHealth() + " energy = " + defender.get(i).getEnergy());
                    logger.AddLog("Defender " + defender.get(i).getName() + " health = " + defender.get(i).getHealth() + " energy = " + defender.get(i).getEnergy());
                }

                if (defender.isEmpty()) {
                    if (defender==enemyTeam){
                        System.out.println("--------------------------------------------------------------------------------------\n");
                        System.out.println("Hero team wins this battle!");
                        logger.AddSeparator();
                        logger.AddLog("Hero team wins this battle!");
                    }
                    else {
                        System.out.println("--------------------------------------------------------------------------------------\n");
                        System.out.println("Enemy team wins this battle!");
                        logger.AddSeparator();
                        logger.AddLog("Enemy team wins this battle!");
                    }

                    for (int i = 0; i < attacker.size(); i++) {
                        System.out.println("Attacker " + attacker.get(i).getName() + " health = " + attacker.get(i).getHealth());
                        logger.AddLog("Attacker " + attacker.get(i).getName() + " health = " + attacker.get(i).getHealth());
                    }
                    break;
                }
                System.out.println("--------------------------------------------------------------------------------------\n");
                logger.AddSeparator();
            }
        }
    }
}
