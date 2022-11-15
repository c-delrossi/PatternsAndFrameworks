import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class ClockConfig {
    private IOStrategy strategy;
    private int refreshRate;

    public void loadConfig() throws ClockException {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("ClockConfig.properties")) {
            Properties props = new Properties();
            props.load(input);

            strategy = (IOStrategy) Class.forName(props.getProperty("clock.io.strategy"))
                    .getDeclaredConstructor().newInstance();
            refreshRate = Integer.parseInt(props.getProperty("clock.refreshRate"));
            if (refreshRate < 0 || refreshRate > 60 * 60) {
                throw new IllegalArgumentException("RefreshRate must be between 0 and 3600 seconds!");
            }
        } catch (IOException | ClassNotFoundException | NoSuchMethodException | InstantiationException |InvocationTargetException | IllegalAccessException exception) {
            ClockException clockException = new ClockException(exception.getMessage());
            clockException.setStackTrace(exception.getStackTrace());
            throw clockException;
        }
    }

    public IOStrategy getStrategy() {
        return strategy;
    }

    public int getRefreshRate() {
        return refreshRate;
    }
}
