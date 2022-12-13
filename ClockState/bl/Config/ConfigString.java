import java.util.Optional;
import java.util.OptionalDouble;

public class ConfigString extends ConfigBase {
    public ConfigString(String value) {
        type = ConfigType.ConfigString;
        this.value = value;
    }

    private String  getValue() {
        return (String) value;
    }

    @Override
    public OptionalDouble asNumber() {
        return OptionalDouble.empty();
    }

    @Override
    public Optional<String> asString() {
        return Optional.of((String) value);
    }
}
