package team.dto.request;

public class TransactionInfoRequestDto {
    private Long playerId;
    private Long destinationTeamId;

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Long getDestinationTeamId() {
        return destinationTeamId;
    }

    public void setDestinationTeamId(Long destinationTeamId) {
        this.destinationTeamId = destinationTeamId;
    }
}
