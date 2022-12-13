import java.util.Optional;
import java.util.OptionalDouble;

public class ConfigNumber extends ConfigBase {
    public ConfigNumber(int value) {
        type = ConfigType.ConfigNumber;
        this.value = value;
    }

    private int getValue() {
        return (int) value;
    }

    @Override
    public OptionalDouble asNumber() {
        return OptionalDouble.of(getValue());
    }

    @Override
    public Optional<String> asString() {
        return Optional.of(Integer.toString(getValue()));
    }
}
