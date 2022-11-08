import java.util.Objects;

public final class Seconds {
    private final int seconds;

    public Seconds(int amount) {
        if (amount >= 60) {
            seconds = 59;
        } else {
            seconds = Math.max(amount, 0);
        }
    }

    public Seconds next() {
        return new Seconds((seconds + 1) % 60);
    }

    public int getSeconds() {
        return seconds;
    }

    @Override
    public String toString() {
        if (seconds > 9) {
            return Integer.toString(seconds);
        } else {
            return "0" + seconds;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seconds seconds1 = (Seconds) o;
        return seconds == seconds1.seconds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(seconds);
    }
}
