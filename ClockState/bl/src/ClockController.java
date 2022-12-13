public class ClockController {
    private final Clock clock = new Clock();
    private final IOStrategy ioStrategy;
    private boolean ended = false;

    private final int refreshRate;

    public ClockController() {
        ConfigAnything configAnything = new ConfigObject();
        ConfigAnything clock = new ConfigObject();
        ConfigAnything io = new ConfigObject();

        configAnything.set("clock", clock);
        clock.set("io", io);

        clock.set("refreshRate", new ConfigNumber(5));
        io.set("strategy", new ConfigString("ConsoleStrategy"));

        ClockConfig config = new ClockConfig(configAnything);
        this.ioStrategy = config.getStrategy();
        this.refreshRate = config.getRefreshRate();
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
        ClockTimer clockTimer = new ClockTimer();
        clockTimer.subscribe(this);
        while (!ended) {
            String command = ioStrategy.read();
            executeCommand(command);
        }
        clockTimer.cancel();
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

    private boolean shouldRefresh() {
        Time time = clock.getTime();
        int secondsSinceMidnight = time.getSeconds() + 60 * (time.getMinutes() + 24 * time.getHours());
        return secondsSinceMidnight % refreshRate == 0 && clock.isOn();
    }

    public void tick() {
        clock.tick();
        if (shouldRefresh()) {
            displayClock();
            displayMenu();
        }
    }
}
