import java.util.Objects;

public final class Time {
    private final Hours hours;
    private final Minutes minutes;
    private final Seconds seconds;

    public Time(Hours hours, Minutes minutes, Seconds seconds) {
        this.hours = Objects.requireNonNullElseGet(hours, () -> new Hours(0));
        this.minutes = Objects.requireNonNullElseGet(minutes, () -> new Minutes(0));
        this.seconds = Objects.requireNonNullElseGet(seconds, () -> new Seconds(0));
    }

    public int getHours() {
        return hours.getHours();
    }

    public int getMinutes() {
        return minutes.getMinutes();
    }

    public int getSeconds() {
        return seconds.getSeconds();
    }

    @Override
    public String toString() {
        return hours + ":" + minutes + ":" + seconds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return hours.equals(time.hours) && minutes.equals(time.minutes) && seconds.equals(time.seconds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hours, minutes, seconds);
    }
}
