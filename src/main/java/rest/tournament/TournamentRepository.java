package rest.tournament;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    Iterable<Tournament> findAllByStartDate(LocalDate startDate);
    Iterable<Tournament> findAllByLocation(String location);
}
