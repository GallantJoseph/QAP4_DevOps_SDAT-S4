package rest.tournament;

import jakarta.persistence.*;
import rest.member.Member;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Tournament {
    @Id
    @SequenceGenerator(name = "tournament_sequence", sequenceName = "tournament_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tournament_sequence")
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private float entryFee;
    private float prizeAmount;

    @ManyToMany
    private Set<Member> members = new HashSet<>();

    public Tournament() {

    }

    public Tournament(LocalDate startDate, LocalDate endDate, String location, float entryFee, float prizeAmount) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.entryFee = entryFee;
        this.prizeAmount = prizeAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(float entryFee) {
        this.entryFee = entryFee;
    }

    public float getPrizeAmount() {
        return prizeAmount;
    }

    public void setPrizeAmount(float prizeAmount) {
        this.prizeAmount = prizeAmount;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Tournament( id = " + id +
                ", startDate = " + startDate +
                ", endDate = " + endDate +
                ", location = " + location +
                ", entryFee = " + entryFee +
                ", prizeAmount = " + prizeAmount +
                ", members = " + members + " )";
    }
}
