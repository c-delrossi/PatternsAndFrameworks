public abstract class SetTimeState extends ClockState {
    public SetTimeState(ClockContext context) {
        super(context);
    }

    @Override
    public Class<? extends ClockState> toggleSettings() {
        return OnState.class;
    }

    @Override
    public Class<? extends ClockState> onOff() {
        return OffState.class;
    }

    @Override
    public Class<? extends ClockState> tick() {
        context.tick();
        return this.getClass();
    }
}
