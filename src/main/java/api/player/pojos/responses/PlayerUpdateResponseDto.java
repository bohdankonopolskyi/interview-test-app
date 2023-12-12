package api.player.pojos.responses;

import lombok.Data;

@Data
public class PlayerUpdateResponseDto {
    private int age;
    private String gender;
    private int id;
    private String login;
    private String role;
    private String screenName;
}
