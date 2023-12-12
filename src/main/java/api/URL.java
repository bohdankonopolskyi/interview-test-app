package api;

public enum URL implements RawValueEnum {
    BASE_URL("http://3.68.165.45");

    private String rawValue;

    URL(String rawValue) {
        this.rawValue = rawValue;
    }

    @Override
    public String getRawValue() {
        return rawValue;
    }
}
