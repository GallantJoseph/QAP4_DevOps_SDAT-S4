package rest.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Iterable<Member> findAllByFirstName(String firstName);
    Iterable<Member> findAllByLastName(String lastName);
    Iterable<Member> findAllByMembershipType(String membershipType);
    Iterable<Member> findAllByPhone(String phone);
}
