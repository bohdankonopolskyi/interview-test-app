package api.player;

import api.RawValueEnum;

public enum PlayerRole implements RawValueEnum {
    SUPERVISOR("supervisor"),
    ADMIN("admin"),
    USER("user");

    private final String rawValue;

    PlayerRole(String rawValue) {
        this.rawValue = rawValue;
    }

    public String getRawValue() {
        return rawValue;
    }
}
