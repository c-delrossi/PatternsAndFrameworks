public class SetMinuteState extends SetTimeState {
    public SetMinuteState(ClockContext context) {
        super(context);
    }

    @Override
    public Class<? extends ClockState> increment() {
        context.incrementMinutes();
        System.out.println(context.getTime());
        return this.getClass();
    }

    @Override
    public Class<? extends ClockState> changeMode() {
        return SetHourState.class;
    }
}
