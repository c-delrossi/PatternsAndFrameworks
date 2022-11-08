public class SetHourState extends SetTimeState {
    public SetHourState(ClockContext context) {
        super(context);
    }

    @Override
    public Class<? extends ClockState> increment() {
        context.incrementHours();
        return this.getClass();
    }

    @Override
    public Class<? extends ClockState> changeMode() {
        return SetMinuteState.class;
    }
}
