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
}
