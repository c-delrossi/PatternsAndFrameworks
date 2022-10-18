import java.util.HashMap;

public class Clock {
    private final ClockContext context = new ClockContext();
    private ClockState current;
    private final HashMap<Class<? extends ClockState>, ClockState> stateMap = new HashMap<>();

    public Clock() {
        stateMap.put(OnState.class, new OnState(context));
        stateMap.put(SetMinuteState.class, new SetMinuteState(context));
        stateMap.put(SetHourState.class, new SetHourState(context));
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

    public void changeMode() {
        changeState(current.changeMode());
    }

    public void increment() {
        changeState(current.increment());
    }

    public void toggleSettings() {
        changeState(current.toggleSettings());
    }

    private void changeState(Class<? extends ClockState> stateClass) {
        current = stateMap.get(stateClass);
    }
}
