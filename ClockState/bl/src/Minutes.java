import java.util.Objects;

public final class Minutes {
    private final int minutes;

    public Minutes(int amount) {
        if (amount < 0) {
            minutes = 0;
        } else {
            minutes = Math.min(amount, 59);
        }
    }

    public Minutes next() {
        return new Minutes((minutes + 1) % 60);
    }

    public int getMinutes() {
        return minutes;
    }

    @Override
    public String toString() {
        if (minutes < 10) {
            return "0" + minutes;
        } else {
            return Integer.toString(minutes);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Minutes minutes1 = (Minutes) o;
        return minutes == minutes1.minutes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minutes);
    }
}
