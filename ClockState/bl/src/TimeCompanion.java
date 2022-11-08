import java.util.Objects;

public final class TimeCompanion {
    private int hours;
    private int minutes;
    private int seconds;

    public TimeCompanion(Time time) {
        this.hours = time.getHours();
        this.minutes = time.getMinutes();
        this.seconds = time.getSeconds();
    }

    public Time getTime() {
        return new Time(new Hours(hours), new Minutes(minutes), new Seconds(seconds));
    }

    public void setTime(Time time) {
        this.hours = time.getHours();
        this.minutes = time.getMinutes();
        this.seconds = time.getSeconds();
    }

    public void next() {
        nextSecond();
    }

    public void nextSecond() {
        seconds = (seconds + 1) % 60;
        if (seconds == 0) {
            nextMinute();
        }
    }

    public void nextMinute() {
        minutes = (minutes + 1) % 60;
        if (minutes == 0) {
            this.nextHour();
        }
    }

    public void nextHour() {
        hours = (hours + 1) % 24;
    }

    public void addSeconds(int amount) {
        int seconds = amount % 60;
        int minutes = amount / 60;
        int previousSeconds = this.seconds;
        this.seconds = (this.seconds + seconds) % 60;
        if (this.seconds < previousSeconds) {
            minutes += 1;
        }
        addMinutes(minutes);
    }

    public void addMinutes(int amount) {
        int minutes = amount % 60;
        int hours = amount / 60;
        int previousMinutes = this.minutes;
        this.minutes = (this.minutes + minutes) % 60;
        if (this.minutes < previousMinutes) {
            hours++;
        }
        addHours(hours);
    }

    public void addHours(int amount) {
        this.hours = (this.hours + amount) % 24;
    }
}
