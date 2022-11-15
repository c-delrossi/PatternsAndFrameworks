import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

class ClockTimer {
    private final Timer timer = new Timer();
    private final List<ClockController> controllerList = new LinkedList<>();
    private volatile ClockController[] subscribedControllers = new ClockController[0];

    public ClockTimer() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (ClockController controller : controllerList) {
                    controller.tick();
                }
            }
        }, 0, 1000);
    }

    public void subscribe(ClockController controller) {
        controllerList.add(controller);
        subscribedControllers = controllerList.toArray(ClockController[]::new);
    }

    public void unsubscribe(ClockController controller) {
        controllerList.remove(controller);
        subscribedControllers = controllerList.toArray(ClockController[]::new);
    }

    public void cancel() {
        timer.cancel();
    }
}
