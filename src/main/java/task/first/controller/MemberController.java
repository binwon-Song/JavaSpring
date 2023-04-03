package task.first.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import task.first.serivce.MemberService;

@Controller
public class MemberController {

    private final MemberService memberService ;

    @Autowired // 생성자 주입
    public MemberController(MemberService memberService) { //MemeberService를 인식 못함
        this.memberService = memberService;
    }
}
