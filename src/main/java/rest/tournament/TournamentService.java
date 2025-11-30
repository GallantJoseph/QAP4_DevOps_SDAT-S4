package rest.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TournamentService {
    @Autowired
    private TournamentRepository aircraftRepository;
}
