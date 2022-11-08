public class OffState extends ClockState{
    public OffState(ClockContext context) {
        super(context);
    }

    @Override
    public Class<? extends ClockState> onOff() {
        return OnState.class;
    }

    @Override
    public Class<? extends ClockState> tick() {
        return this.getClass();
    }

    @Override
    public Class<? extends ClockState> increment() {
        return this.getClass();
    }

    @Override
    public Class<? extends ClockState> toggleSettings() {
        return this.getClass();
    }

    @Override
    public Class<? extends ClockState> changeMode() {
        return this.getClass();
    }
}
