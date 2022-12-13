public abstract class ConfigBase implements ConfigAnything {
    protected String key;
    protected Object value;
    protected ConfigType type;

    @Override
    public ConfigType getType() {
        return type;
    }

    @Override
    public ConfigAnything get(String key) {
        throw new IllegalArgumentException("Key does not exist!");
    }

    @Override
    public boolean has(String key) {
        return false;
    }

    @Override
    public void set(String key, ConfigAnything any) {
        throw new IllegalArgumentException("Cannot set value!");
    }
}
