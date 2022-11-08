public class SetMinuteState extends SetTimeState {
    public SetMinuteState(ClockContext context) {
        super(context);
    }

    @Override
    public Class<? extends ClockState> increment() {
        context.incrementMinutes();
        return this.getClass();
    }

    @Override
    public Class<? extends ClockState> changeMode() {
        return SetHourState.class;
    }
}
