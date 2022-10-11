public class Main {
    public static void main(String[] args) {
        Clock clock = new Clock();
        clock.onOff();
        clock.tick();
        clock.tick();
        clock.onOff();
        clock.tick();
        clock.onOff();
        clock.tick();
    }
}
