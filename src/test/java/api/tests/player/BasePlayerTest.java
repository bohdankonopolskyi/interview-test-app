package api.tests.player;

import api.player.PlayerRole;
import api.player.pojos.requests.PlayerGetByIdRequestDto;
import api.player.pojos.responses.PlayerItemResponseDto;
import api.player.pojos.responses.PlayerResponseDto;
import api.player.requests.GetAllPlayersRequest;
import api.player.requests.GetPlayerByIdRequest;
import api.utils.Mapper;
import io.restassured.response.Response;
import org.testng.Assert;

public class BasePlayerTest {
    protected PlayerResponseDto getSupervisor() {
        Response response = new GetAllPlayersRequest().send();

        PlayerItemResponseDto supervisor = Mapper.mapToList(response, "players", PlayerItemResponseDto.class)
                .stream()
                .filter(player -> PlayerRole.SUPERVISOR.getRawValue().equals(player.getRole()))
                .findFirst()
                .orElse(null); // Set to null if no supervisor is found

        if (supervisor != null) {
            PlayerGetByIdRequestDto requestDto = PlayerGetByIdRequestDto.builder().playerId(supervisor.getId()).build();
            Response responseById = new GetPlayerByIdRequest().send(requestDto);
            return Mapper.mapToClass(responseById, PlayerResponseDto.class);
        } else {
            Assert.fail("No supervisor was found");
            return null;
        }
    }
}
