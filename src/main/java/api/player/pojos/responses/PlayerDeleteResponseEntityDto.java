package api.player.pojos.responses;

import lombok.Data;

@Data
public class PlayerDeleteResponseEntityDto {
    private Object body;
    private String statusCode;
    private Integer statusCodeValue;
}
