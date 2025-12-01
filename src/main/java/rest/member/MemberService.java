package rest.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
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

        return memberRepository.save(memberToUpdate);
    }

    public Member deleteMemberById(Long id) {
        Optional<Member> memberOptional = memberRepository.findById(id);

        if (memberOptional.isEmpty())
            return null;

        memberRepository.deleteById(id);

        return memberOptional.get();
    }
}
