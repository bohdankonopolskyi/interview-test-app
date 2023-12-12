package api.player.requests;

import api.BaseRequest;
import api.RequestDto;
import api.player.PlayerEndpoint;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j;

@Log4j
public class UpdatePlayerRequest extends BaseRequest {
    private int id;
    private String editor;

    public UpdatePlayerRequest(String editor, int playerId) {
        super(PlayerEndpoint.UPDATE.getRawValue());
        this.id = playerId;
        this.editor = editor;
    }

    @Step("Update player")
    @Override
    public Response send(RequestDto requestModel) {
        log.info("Update player");
        return requestConfig()
                .pathParam("editor", editor)
                .pathParam("id", id)
                .body(requestModel)
                .when()
                .log().all()
                .patch();
    }
}
