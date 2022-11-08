import java.util.LinkedList;
import java.util.List;
import java.util.TimerTask;

class TickTimerTask extends TimerTask {
    private final List<ClockController> controllerList = new LinkedList<>();

    @Override
    public void run() {
        for (ClockController controller : controllerList) {
            controller.tick();
        }
    }

    public void subscribe(ClockController controller) {
        controllerList.add(controller);
    }

    public void unsubscribe(ClockController controller) {
        controllerList.remove(controller);
    }
}
