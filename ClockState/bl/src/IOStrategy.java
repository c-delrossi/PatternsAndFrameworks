public interface IOStrategy {
    void display(Time time);
    void write(String string);
    String read();
}
