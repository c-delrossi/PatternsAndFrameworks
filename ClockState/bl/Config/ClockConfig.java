import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class ClockConfig {
    private ConfigAnything config;

    public ClockConfig(ConfigAnything config) {
        this.config = config;
    }

    public IOStrategy getStrategy() {
        String strategyString = config.get("clock").get("io").get("strategy").asString().get();
        try {
            return (IOStrategy) Class.forName(strategyString).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException |InvocationTargetException | IllegalAccessException exception) {
            ClockException clockException = new ClockException(exception.getMessage());
            clockException.setStackTrace(exception.getStackTrace());
            throw clockException;
        }

    }

    public int getRefreshRate() {
        return (int) Math.round(config.get("clock").get("refreshRate").asNumber().getAsDouble());
    }
}
