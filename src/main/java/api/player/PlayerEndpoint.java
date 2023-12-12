package api.player;

import api.RawValueEnum;

public enum PlayerEndpoint implements RawValueEnum {
    GET("/player/get/"),
    GET_ALL("/player/get/all/"),
    CREATE("/player/create/{editor}/"),
    UPDATE("/player/update/{editor}/{id}/"),
    DELETE("/player/delete/{editor}/");

    private final String rawValue;

    PlayerEndpoint(String rawValue) {
        this.rawValue = rawValue;
    }

    public String getRawValue() {
        return rawValue;
    }

}
