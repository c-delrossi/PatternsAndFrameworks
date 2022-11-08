import java.util.Objects;

public final class Hours {
    private final int hours;

    public Hours(int amount) {

        if (amount < 0) {
            hours = 0;
        } else {
            hours = Math.min(amount, 23);
        }
    }

    public Hours next() {
        return new Hours((hours + 1) % 24);
    }

    public int getHours() {
        return hours;
    }

    @Override
    public String toString() {
        if (hours < 10) {
            return "0" + hours;
        } else {
            return Integer.toString(hours);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hours hours1 = (Hours) o;
        return hours == hours1.hours;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hours);
    }
}
