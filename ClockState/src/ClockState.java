import java.time.Clock;

public abstract class ClockState {
    protected ClockContext context;

    public ClockState(ClockContext context) {
        this.context = context;
    }

    public abstract Class<? extends ClockState> onOff();
    public abstract Class<? extends ClockState> tick();
}
