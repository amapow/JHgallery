package kr.co.photograph.jhgallery.contoller;

import kr.co.photograph.jhgallery.domain.dto.MemberDto;
import kr.co.photograph.jhgallery.service.MemberAuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;


@Controller
@AllArgsConstructor
public class LoginContoller {
    private MemberAuthService memberAuthService;

    @GetMapping("/login")
    public String dispLogin() {
        return "/login/login";
    }

    @GetMapping("/signup")
    public String dispSignup() {
        return "/login/signup";
    }

    @PostMapping("/signup/exec")
    public String execSignup(MemberDto memberDto) {
        memberAuthService.joinUser(memberDto);
        return "redirect:/login";
    }

    @GetMapping("/login/result")
    public String dispLoginResult() {
        return "/login/loginSuccess";
    }

    @GetMapping("/logout/result")
    public String dispLogout() {
        return "/login/logout";
    }

    @GetMapping("/login/denied")
    public String dispDenied() {
        return "/login/denied";
    }

    @RequestMapping(value="/admin")
    public String dispAdmin() {
        return "/admin/admin";
    }
}
