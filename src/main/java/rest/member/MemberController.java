package rest.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/members")
@CrossOrigin
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping()
    public ResponseEntity<Member> saveMember(@RequestBody Member member) {
        return new ResponseEntity<>(memberService.saveMember(member), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Iterable<Member>> getAllMembers() {
        return new ResponseEntity<>(memberService.getAllMembers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(memberService.getMemberById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMemberById(@PathVariable("id") Long id, @RequestBody Member member) {
        return new ResponseEntity<>(memberService.updateMemberById(id, member), HttpStatus.OK) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Member> deleteMemberById(@PathVariable("id") long id) {
        return new ResponseEntity<>(memberService.deleteMemberById(id), HttpStatus.OK);
    }

    @GetMapping("/members_search")
    public Iterable<Member> searchMembers(@RequestParam(value = "first_name", required = false) String firstName,
                                            @RequestParam(value = "last_name", required = false) String last_name,
                                            @RequestParam(value = "membership_type", required = false) String membershipType,
                                            @RequestParam(value = "phone", required = false) String phone,
                                            @RequestParam(value = "tournament_start_date", required = false) String tournamentStartDate) {

        Iterable<Member> membersList = new ArrayList<>();

        if (firstName != null)
            membersList = memberService.findAllByFirstName(firstName);

        else if (last_name != null)
            membersList = memberService.findAllByLastName(last_name);

        else if (membershipType != null)
            membersList = memberService.findAllByMembershipType(membershipType);

        else if (phone != null)
            membersList = memberService.findAllByPhone(phone);

        else if (tournamentStartDate != null) {
            membersList = memberService.findAllBy_Tournament_startDate(tournamentStartDate);
        }

        return membersList;

    }

}