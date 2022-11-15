import java.util.Scanner;

public class ConsoleStrategy implements IOStrategy {
    private final Scanner sc = new Scanner(System.in);
    private String getDisplayString(Time time) {
        String hours = time.getHours() < 10 ? "0" + time.getHours() : Integer.toString(time.getHours());
        String minutes = time.getMinutes() < 10 ? "0" + time.getMinutes() : Integer.toString(time.getMinutes());
        String seconds = time.getSeconds() < 10 ? "0" + time.getSeconds() : Integer.toString(time.getSeconds());
        return "------------\n| " + hours + ":" + minutes + ":" + seconds + " |\n------------";
    }
    @Override
    public void display(Time time) {
        System.out.println(getDisplayString(time));
    }

    @Override
    public void write(String string) {
        System.out.println(string);
    }

    @Override
    public String read() {
        return sc.next();
    }
}
