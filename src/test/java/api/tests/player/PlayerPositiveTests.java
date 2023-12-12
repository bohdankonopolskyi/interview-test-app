package api.tests.player;

import api.player.PlayerAssertion;
import api.player.pojos.requests.PlayerGetByIdRequestDto;
import api.player.pojos.requests.PlayerRequestDto;
import api.player.pojos.responses.PlayerItemResponseDto;
import api.player.pojos.responses.PlayerResponseDto;
import api.player.requests.CreatePlayerRequest;
import api.player.requests.GetAllPlayersRequest;
import api.player.requests.GetPlayerByIdRequest;
import api.utils.Mapper;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class PlayerPositiveTests extends BasePlayerTest {

    @Test
    public void createPlayerTest() {
        PlayerRequestDto playerRequest = PlayerRequestDto.builder().build();

        var supervisor = getSupervisor();
        Response response = new CreatePlayerRequest(supervisor.getLogin())
                .send(playerRequest)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        PlayerResponseDto playerResponseDto = Mapper.mapToClass(response, PlayerResponseDto.class);

        PlayerAssertion.softAssert(playerRequest, playerResponseDto);
    }

    @Test
    public void getPlayerByIdTest() {
        PlayerRequestDto playerRequest = PlayerRequestDto.builder().build();
        var supervisor = getSupervisor();
        Response response = new CreatePlayerRequest(supervisor.getLogin())
                .send(playerRequest)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        PlayerResponseDto playerResponseDto = Mapper.mapToClass(response, PlayerResponseDto.class);

        PlayerGetByIdRequestDto playerGetByIdRequestDto = new PlayerGetByIdRequestDto(playerResponseDto.getId());
        Response responseById = new GetPlayerByIdRequest().send(playerGetByIdRequestDto)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        PlayerResponseDto playerResponseDtoById = Mapper.mapToClass(responseById, PlayerResponseDto.class);
        PlayerAssertion.softAssert(playerRequest, playerResponseDtoById);
    }

    @Test
    public void getAllPlayersTest() {
        PlayerRequestDto playerRequest = PlayerRequestDto.builder().build();
        var supervisor = getSupervisor();
        new CreatePlayerRequest(supervisor.getLogin())
                .send(playerRequest)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        Response response = new GetAllPlayersRequest()
                .send()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        PlayerItemResponseDto playerItemResponseDto = Mapper.mapToList(response, "players", PlayerItemResponseDto.class).stream()
                .filter(player -> player.getScreenName().equals(playerRequest.getScreenName()))
                .findFirst()
                .orElseThrow();

        PlayerAssertion.softAssert(playerRequest, playerItemResponseDto);
    }
}
