public class ClockContext {
    private final TimeCompanion timeCompanion;

    public ClockContext() {
        timeCompanion = new TimeCompanion(new Time(null, null, null));
    }

    public void tick() {
        timeCompanion.next();
    }

    public void incrementMinutes() {
        timeCompanion.nextMinute();
    }

    public void incrementHours() {
        timeCompanion.nextHour();
    }

    public String getTimeToString() {
        return timeCompanion.getTime().toString();
    }

    public Time getTime() {
        return timeCompanion.getTime();
    }
}
