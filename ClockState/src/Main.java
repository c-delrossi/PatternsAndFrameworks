import java.util.Scanner;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        TickTimerTask timerTask = new TickTimerTask();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
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
                case "t" -> clock.toggleSettings();
                case "i" -> clock.increment();
                case "m" -> clock.changeMode();
                default -> System.out.println("Command not recognized!");
            }
        }
        timer.cancel();
    }
}
