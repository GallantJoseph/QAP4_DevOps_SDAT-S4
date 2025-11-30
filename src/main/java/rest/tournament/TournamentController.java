package rest.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tournament")
@CrossOrigin
public class TournamentController {
    @Autowired
    private TournamentService tournamentService;
}