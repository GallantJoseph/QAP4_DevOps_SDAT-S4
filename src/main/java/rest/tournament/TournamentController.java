package rest.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.member.Member;

import java.util.ArrayList;

@RestController
@RequestMapping("/tournaments")
@CrossOrigin
public class TournamentController {
    @Autowired
    private TournamentService tournamentService;

    @PostMapping()
    public ResponseEntity<Tournament> saveTournament(@RequestBody Tournament tournament) {
        return new ResponseEntity<>(tournamentService.saveTournament(tournament), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Iterable<Tournament>> getAllTournaments() {
        return new ResponseEntity<>(tournamentService.getAllTournaments(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tournament> getTournamentById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(tournamentService.getTournamentById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tournament> updateTournamentById(@PathVariable("id") Long id, @RequestBody Tournament tournament) {
        return new ResponseEntity<>(tournamentService.updateTournamentById(id, tournament), HttpStatus.OK) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tournament> deleteTournamentById(@PathVariable("id") long id) {
        return new ResponseEntity<>(tournamentService.deleteTournamentById(id), HttpStatus.OK);
    }

    @GetMapping("/tournaments_search")
    public Iterable<Tournament> searchTournaments(@RequestParam(value = "start_date", required = false) String startDate,
                                                  @RequestParam(value = "location", required = false) String location) {

        Iterable<Tournament> tournamentsList = new ArrayList<>();

        if (startDate != null)
            tournamentsList = tournamentService.findAllByStartDate(startDate);

        else if (location != null)
            tournamentsList = tournamentService.findAllByLocation(location);

        return tournamentsList;
    }

    @PostMapping("/{tournamentId}/{memberId}")
    public ResponseEntity<Tournament> addTournamentMember(@PathVariable("tournamentId") Long tournamentId,
                                                          @PathVariable("memberId") Long memberId) {
        return new ResponseEntity<>(tournamentService.addTournamentMember(tournamentId, memberId), HttpStatus.OK) ;
    }

    @GetMapping("/{id}/members")
    public Iterable<Member> getTournamentMembers(@PathVariable("id") Long id) {
        Iterable<Member> membersList = new ArrayList<>();

        Tournament tournament = tournamentService.getTournamentById(id);

        if (tournament != null) {
            membersList = tournament.getMembers();
        }

        return membersList;
    }

    @DeleteMapping("/{tournamentId}/{memberId}")
    public ResponseEntity<Tournament> deleteTournamentMember(@PathVariable("tournamentId") Long tournamentId,
                                                             @PathVariable("memberId") Long memberId) {

        return new ResponseEntity<>(tournamentService.deleteTournamentMember(tournamentId, memberId), HttpStatus.OK);
    }
}