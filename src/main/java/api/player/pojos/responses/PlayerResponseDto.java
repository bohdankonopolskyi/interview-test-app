package api.player.pojos.responses;

import api.RequestDto;
import lombok.Data;

@Data
public class PlayerResponseDto {

    private int age;
    private String gender;
    private int id;
    private String login;
    private String password;
    private String role;
    private String screenName;
}
