package kr.co.photograph.jhgallery.contoller;

import kr.co.photograph.jhgallery.domain.dto.MemberDto;
import kr.co.photograph.jhgallery.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@AllArgsConstructor
public class LoginContoller {
    private MemberService memberService;

    @GetMapping("/user/signup")
    public String dispSignup() {
        return "/user/signup";
    }

    @RequestMapping(value = "/user/signup", method = RequestMethod.POST)
    public String execSignup(MemberDto memberDto) {
        memberService.joinUser(memberDto);
        return "redirect:/login";
    }

    @GetMapping("/login/result")
    public String dispLoginResult() {
        return "/user/loginSuccess";
    }

    @GetMapping("/logout/result")
    public String dispLogout() {
        return "/user/logout";
    }

    @GetMapping("/denied")
    public String dispDenied() {
        return "/user/denied";
    }

    @RequestMapping(value="/admin")
    public String dispAdmin() {
        return "/admin/admin";
    }
}
