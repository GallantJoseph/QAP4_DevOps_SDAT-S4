package rest.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.member.Member;

import java.time.LocalDate;

@Service
public class TournamentService {
    @Autowired
    private TournamentRepository tournamentRepository;

}
