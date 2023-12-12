package api.player.pojos.requests;

import api.RequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class PlayerGetByIdRequestDto implements RequestDto {
    private Integer playerId;
}
