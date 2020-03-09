package kr.co.photograph.jhgallery.contoller;

import kr.co.photograph.jhgallery.service.MemberAuthService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class LoginContoller {
    private MemberAuthService memberAuthService;

    @GetMapping("/signup")
    public String dispSignup() {
        return "/signup";
    }

    @GetMapping("/login")
    public String dspLongin() {
        return "/login";
    }

    @GetMapping("/login/result")
    public String dspLoginResult() {
        return "/loginSuccess";
    }

    @GetMapping("/logout/result")
    public String dispLogout() {
        return "/logout";
    }

    @GetMapping("/denied")
    public String dispDenied() {
        return "/denied";
    }
}
