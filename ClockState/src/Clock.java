import java.util.HashMap;

public class Clock {
    private final ClockContext context = new ClockContext();
    private ClockState current;
    private final HashMap<Class<? extends ClockState>, ClockState> stateMap = new HashMap<>();

    public Clock() {
        stateMap.put(OnState.class, new OnState(context));
        var offState = new OffState(context);
        stateMap.put(OffState.class, offState);
        current = offState;
    }

    public void tick() {
        changeState(current.tick());
    }

    public void onOff() {
        changeState(current.onOff());
    }

    private void changeState(Class<? extends ClockState> stateClass) {
        current = stateMap.get(stateClass);
    }
}
