package rest.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@CrossOrigin
public class MemberController {
    @Autowired
    private MemberService memberService;
}