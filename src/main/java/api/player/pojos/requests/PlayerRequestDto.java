package api.player.pojos.requests;

import api.RequestDto;
import api.player.PlayerRole;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PlayerRequestDto implements RequestDto {

    @Builder.Default
    private int age = 18;
    @Builder.Default
    private String gender = "male";
    @Builder.Default
    private String login = "login" +  System.currentTimeMillis();
    @Builder.Default
    private String password = "pass" + System.currentTimeMillis();
    @Builder.Default
    private String role = PlayerRole.USER.getRawValue();
    @Builder.Default
    private String screenName = "Name" + System.currentTimeMillis();
}
