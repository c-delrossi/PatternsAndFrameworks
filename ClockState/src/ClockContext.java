public class ClockContext {
    public int seconds;
    public int minutes;
    public int hours;

    public void incrementSeconds() {
        seconds = ++seconds % 60;
        if (seconds == 0)
            incrementMinutes();
    }

    public void incrementMinutes() {
        minutes = ++minutes % 60;
        if (minutes == 0)
            incrementHours();
    }

    public void incrementHours() {
        hours = ++hours % 60;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getHours() {
        return hours;
    }
}
