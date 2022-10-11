import java.util.LinkedList;
import java.util.List;
import java.util.TimerTask;

class TickTimerTask extends TimerTask {
    private final List<Clock> clockList = new LinkedList<>();

    @Override
    public void run() {
        for (Clock clock : clockList) {
            clock.tick();
        }
    }

    public void subscribe(Clock clock) {
        clockList.add(clock);
    }

    public void unsubscribe(Clock clock) {
        clockList.remove(clock);
    }
}
