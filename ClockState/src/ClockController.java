import java.util.Scanner;
import java.util.Timer;

public class ClockController {
    private final Clock clock = new Clock();
    private final IOStrategy ioStrategy;
    private boolean ended = false;

    public ClockController(IOStrategy ioStrategy) {
        this.ioStrategy = ioStrategy;
    }

    private void executeCommand(String input) {
        switch (input) {
            case "1" -> onOff();
            case "2" -> toggleSettings();
            case "3" -> increment();
            case "4" -> changeMode();
            default -> ended = true;
        }
    }

    private String getMode() {
        if (clock.isChangingSettings()) {
            return "Setting Time...";
        }
        return null;
    }

    private String getCommands() {
        if (clock.isIncrementingHours()) {
            return """
                   1) Toggle Power
                   2) Quit Settings
                   3) Increment Hours
                   4) Switch to incrementing Minutes
                   """;
        } else if (clock.isIncrementingMinutes()) {
            return """
                   1) Toggle Power
                   2) Quit Settings
                   3) Increment Minutes
                   4) Switch to incrementing Hours
                   """;
        } else {
            return """
                   1) Toggle Power
                   2) Set Time
                   3)
                   4)
                   other) exit
                   """;
        }
    }

    public void run() {
        TickTimerTask timerTask = new TickTimerTask();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
        timerTask.subscribe(this);
        while (!ended) {
            String command = ioStrategy.read();
            executeCommand(command);
        }
        timer.cancel();
    }

    private void increment() {
        clock.increment();
        displayClock();
        displayMenu();
    }

    private void onOff() {
        clock.onOff();
        if (clock.isOn()) {
            displayClock();
            displayMenu();
        }
    }

    private void displayClock() {
        ioStrategy.display(clock.getTime());
    }

    private void displayMenu() {
        if (getMode() != null) {
            ioStrategy.write(getMode());
        }
        ioStrategy.write(getCommands());
    }

    private void toggleSettings() {
        clock.toggleSettings();
        displayClock();
        displayMenu();
    }

    private void changeMode() {
        clock.changeMode();
        displayClock();
        displayMenu();
    }

    public void tick() {
        clock.tick();
        if (clock.isOn() && clock.getTime().getSeconds() == 0) {
            displayClock();
            displayMenu();
        }
    }
}
