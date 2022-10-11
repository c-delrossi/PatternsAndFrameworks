import java.util.Scanner;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        TickTimerTask timerTask = new TickTimerTask();
        new Timer().scheduleAtFixedRate(timerTask, 0, 1000);
        Clock clock = new Clock();
        timerTask.subscribe(clock);
        Scanner sc = new Scanner(System.in);
        boolean ended = false;
        while (!ended) {
            String command = sc.next();
            switch (command) {
                case "o" -> clock.onOff();
                case "e" -> ended = true;
                case "s" -> timerTask.subscribe(clock);
                case "u" -> timerTask.unsubscribe(clock);
                default -> System.out.println("Command not recognized!");
            }
        }
    }
}
