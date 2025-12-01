package rest.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<Member>> getAllMembers() {
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


}