package rest.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.tournament.Tournament;
import rest.tournament.TournamentRepository;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TournamentRepository tournamentRepository;

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    public Iterable<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id) {
        Optional<Member> memberOptional = memberRepository.findById(id);

        return memberOptional.orElse(null);
    }

    public Member updateMemberById(Long id, Member member) {
        Optional<Member> memberOptional = memberRepository.findById(id);

        if (memberOptional.isEmpty())
            return null;

        Member memberToUpdate = memberOptional.get();

        memberToUpdate.setFirstName(member.getFirstName());
        memberToUpdate.setLastName(member.getLastName());
        memberToUpdate.setStreetAddress(member.getStreetAddress());
        memberToUpdate.setCity(member.getCity());
        memberToUpdate.setProvince(member.getProvince());
        memberToUpdate.setEmail(member.getEmail());
        memberToUpdate.setPhone(member.getPhone());
        memberToUpdate.setStartDate(member.getStartDate());
        memberToUpdate.setMembershipDuration(member.getMembershipDuration());
        memberToUpdate.setMembershipType(member.getMembershipType());

        return memberRepository.save(memberToUpdate);
    }

    public Member deleteMemberById(Long id) {
        Optional<Member> memberOptional = memberRepository.findById(id);

        if (memberOptional.isEmpty())
            return null;

        memberRepository.deleteById(id);

        return memberOptional.get();
    }

    public Iterable<Member> findAllByFirstName(String firstName) {
        return memberRepository.findAllByFirstName(firstName);
    }

    public Iterable<Member> findAllByLastName(String lastName) {
        return memberRepository.findAllByLastName(lastName);
    }

    public Iterable<Member> findAllByMembershipType(String membershipType) {
        return memberRepository.findAllByMembershipType(membershipType);
    }

    public Iterable<Member> findAllByPhone(String phone) {
        return memberRepository.findAllByPhone(phone);
    }

    public Iterable<Member> findAllBy_Tournament_startDate(String startDate) {
        Iterable<Tournament> tournamentIterable = tournamentRepository.findAllByStartDate(LocalDate.parse(startDate));
        Set<Member> membersFound = new HashSet<>();

        for (Tournament tournament: tournamentIterable) {
            membersFound.addAll(tournament.getMembers());
        }

        return membersFound;
    }
}
