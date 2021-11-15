package team.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.dto.request.TransactionInfoRequestDto;
import team.model.Player;
import team.model.Team;
import team.service.PlayerService;
import team.service.TeamService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private static final Long CONST_MONEY = 100000L;
    private final PlayerService playerService;
    private final TeamService teamService;

    @Autowired
    public TransactionController(PlayerService playerService, TeamService teamService) {
        this.playerService = playerService;
        this.teamService = teamService;
    }

    @GetMapping
    public Player accomplishTransaction(@RequestBody TransactionInfoRequestDto transactionInfo) {
        Player player = playerService.get(transactionInfo.getPlayerId());
        Team currentTeam = player.getTeam();
        Team destinationTeam = teamService.get(transactionInfo.getDestinationTeamId());
        Long transactionPrice =
                player.getExperience() * CONST_MONEY / player.getAge();
        Long transactionPriceIncludeCommission =
                destinationTeam.getBudged() - transactionPrice
                        + (long) (transactionPrice * currentTeam.getCommission());
        if (destinationTeam.getBudged()
                >= transactionPriceIncludeCommission) {
            destinationTeam.setBudged(destinationTeam.getBudged()
                    - transactionPriceIncludeCommission);
            teamService.update(destinationTeam);
            currentTeam.setBudged(currentTeam.getBudged() + transactionPriceIncludeCommission);
            teamService.update(currentTeam);
            player.setTeam(destinationTeam);
            playerService.update(player);
        }
        return player;
    }
}
