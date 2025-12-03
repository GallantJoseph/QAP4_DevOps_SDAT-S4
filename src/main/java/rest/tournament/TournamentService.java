package rest.tournament;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.member.Member;
import rest.member.MemberRepository;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class TournamentService {
    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private MemberRepository memberRepository;

    public Tournament saveTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public Iterable<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public Tournament getTournamentById(Long id) {
        Optional<Tournament> tournamentOptional = tournamentRepository.findById(id);

        return tournamentOptional.orElse(null);
    }

    public Tournament updateTournamentById(Long id, Tournament tournament) {
        Optional<Tournament> tournamentOptional = tournamentRepository.findById(id);

        if (tournamentOptional.isEmpty())
            return null;

        Tournament tournamentToUpdate = tournamentOptional.get();

        tournamentToUpdate.setStartDate(tournament.getStartDate());
        tournamentToUpdate.setEndDate(tournament.getEndDate());
        tournamentToUpdate.setLocation(tournament.getLocation());
        tournamentToUpdate.setEntryFee(tournament.getEntryFee());
        tournamentToUpdate.setPrizeAmount(tournament.getPrizeAmount());
        tournamentToUpdate.setMembers(tournament.getMembers());

        return tournamentRepository.save(tournamentToUpdate);
    }

    public Tournament deleteTournamentById(Long id) {
        Optional<Tournament> tournamentOptional = tournamentRepository.findById(id);

        if (tournamentOptional.isEmpty())
            return null;

        tournamentRepository.deleteById(id);

        return tournamentOptional.get();
    }

    public Iterable<Tournament> findAllByStartDate(String startDate) {
        return tournamentRepository.findAllByStartDate(LocalDate.parse(startDate));
    }

    public Iterable<Tournament> findAllByLocation(String location) {
        return tournamentRepository.findAllByLocation(location);
    }

    public Tournament addTournamentMember(Long tournamentId, Long memberId) {
        Optional<Tournament> tournament = tournamentRepository.findById(tournamentId);
        Optional<Member> memberToAdd = memberRepository.findById(memberId);

        if (tournament.isPresent() && memberToAdd.isPresent()) {
            Tournament tournamentToUpdate = tournament.get();

            tournamentToUpdate.getMembers().add(memberToAdd.get());
            tournamentRepository.save(tournamentToUpdate);

            return tournamentToUpdate;
        }

        return null;
    }

    public Tournament deleteTournamentMember(Long tournamentId, Long memberId) {
        Optional<Tournament> tournament = tournamentRepository.findById(tournamentId);
        Optional<Member> memberToRemove = memberRepository.findById(memberId);

        if (tournament.isPresent() && memberToRemove.isPresent()) {
            Tournament tournamentToUpdate = tournament.get();

            tournamentToUpdate.getMembers().remove(memberToRemove.get());
            tournamentRepository.save(tournamentToUpdate);

            return tournamentToUpdate;
        }

        return null;
    }

}
