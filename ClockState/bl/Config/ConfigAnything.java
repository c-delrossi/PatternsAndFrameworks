import java.util.Optional;
import java.util.OptionalDouble;

public interface ConfigAnything {
    OptionalDouble asNumber();
    Optional<String> asString();
    ConfigType getType();
    ConfigAnything get(String key);
    boolean has(String key);
    void set(String key, ConfigAnything any);
}
