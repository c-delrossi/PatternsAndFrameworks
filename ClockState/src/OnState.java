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
        context.incrementSeconds();
        System.out.println(context.getHours() + ":" + context.getMinutes() + ":" + context.getSeconds());
        return this.getClass();
    }
}