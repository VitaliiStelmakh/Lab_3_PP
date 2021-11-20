package Main;
import Controller.Battle;
import Controller.Battle1vs1;
import BattleLogger.BattleLog;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String log;
        Battle arena;
        int choose = 256;
        BattleLog logger = new BattleLog();


        while (choose != 0) {
            System.out.println("\n1 - Start 1 vs 1 droid battle");
            System.out.println("2 - Start team vs team droid battle");
            System.out.println("3 - Print last log droid battle");
            System.out.println("0 - Exit");
            choose =1;// scanner.nextInt();


            switch (choose) {
                case 1: {
                    arena = new Battle1vs1();
                    arena.Start();
                    choose=0;
                    break;
                }
//                case 2: {
//                    arena = new ArenaTeamVsTeam();
//                    arena.Start();
//                    break;
//                }
                case 3: {
                    log = logger.GetSessionLog();
                    System.out.println(log);
                    break;
                }
            }
        }
    }
}
