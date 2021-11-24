package Main;
import Controller.Battle;
import Controller.Battle1vs1;
import BattleLogger.BattleLog;
import Controller.BattleTeamVsTeam;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String log;
        Battle battle;
        int choose = 256;
        BattleLog logger = new BattleLog();


        while (choose != 0) {
            System.out.println("\n1 - Start 1 vs 1 droid battle");
            System.out.println("2 - Start team vs team droid battle");
            System.out.println("3 - Print last log droid battle");
            System.out.println("0 - Exit");
            choose  = scanner.nextInt();
            switch (choose) {

                case 1: {
                    battle = new Battle1vs1();
                    battle.Start();
                    break;
                }
                case 2: {
                    battle = new BattleTeamVsTeam();
                    battle.Start();
                    break;
                }
                case 3: {
                    log = logger.GetSessionLog();
                    System.out.println(log);
                    break;
                }
            }
        }
    }
}
