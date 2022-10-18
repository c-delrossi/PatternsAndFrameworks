public class ClockContext {
    private Time time;

    public ClockContext() {
        time = new Time(null, null, null);
    }

    public void tick() {
        time = time.next();
    }

    public void incrementMinutes() {
        time = time.nextMinute();
    }

    public void incrementHours() {
        time = time.nextHour();
    }

    public String getTime() {
        return time.toString();
    }
}
