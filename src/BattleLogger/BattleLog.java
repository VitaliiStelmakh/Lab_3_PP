package BattleLogger;

import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BattleLog {
    public void ClearSessionLog() {
        try(FileWriter writer = new FileWriter("./src/log.txt", false))
        {
            String text = "";
            writer.write(text);

            writer.flush();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String GetSessionLog() {
        String result = "";
        try(FileReader reader = new FileReader("./src/log.txt"))
        {
            Scanner scan = new Scanner(reader);

            while (scan.hasNextLine()) {
                result += scan.nextLine() + "\n";
            }

            if (result.equals("")) {
                result = "No logs in this session";
            }

        } catch (Exception ex) {

            result = ex.getMessage();
        }
        return result;
    }

    public void AddLog(String msg) {
        try(FileWriter writer = new FileWriter("./src/log.txt", true))
        {
            String text = msg + "\n";
            writer.write(text);

            writer.flush();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void AddSeparator() {
        try(FileWriter writer = new FileWriter("./src/log.txt", true))
        {
            String text = "--------------------------------------------------------------------------------------\n";
            writer.write(text);

            writer.flush();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
