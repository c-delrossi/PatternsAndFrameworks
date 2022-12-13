import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;

public class ConfigObject extends ConfigBase {
    public ConfigObject() {
        type = ConfigType.ConfigObject;
        value = new HashMap<String, ConfigAnything>();
    }

    @Override
    public OptionalDouble asNumber() {
        return OptionalDouble.empty();
    }

    @Override
    public Optional<String> asString() {
        return Optional.empty();
    }

    @Override
    public ConfigAnything get(String key) {
        return ((Map<String, ConfigAnything>)value).get(key);
    }

    @Override
    public boolean has(String key) {
        return ((Map<String, ConfigAnything>)value).containsKey(key);
    }

    @Override
    public void set(String key, ConfigAnything any) {
        ((Map<String, ConfigAnything>)value).put(key, any);
    }
}
