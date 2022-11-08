public class ClockProgram {
    public static void main(String[] args) {
        new ClockController(new ConsoleStrategy()).run();
    }
}
