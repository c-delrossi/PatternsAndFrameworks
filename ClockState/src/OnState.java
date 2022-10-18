public class OnState extends ClockState {

    public OnState(ClockContext context) {
        super(context);
    }
    @Override
    public Class<? extends ClockState> onOff() {
        return OffState.class;
    }

    @Override
    public Class<? extends ClockState> tick() {
        context.tick();
        System.out.println(context.getTime());
        return this.getClass();
    }

    @Override
    public Class<? extends ClockState> increment() {
        return this.getClass();
    }

    @Override
    public Class<? extends ClockState> toggleSettings() {
        return SetHourState.class;
    }

    @Override
    public Class<? extends ClockState> changeMode() {
        return this.getClass();
    }
}
