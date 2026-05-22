package com.mjc813.login_cookie.biz;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
    @GetMapping("/")
    public String home(HttpServletResponse response) {
        Cookie ck = new Cookie("mjc813_8", "BackendServer");
        ck.setPath("/");
        ck.setHttpOnly(true);
        ck.setMaxAge(60);
        response.addCookie(ck);
        return "home";
    }

    @GetMapping("/get_info")
    public String getInfo(HttpServletRequest request) {
        StringBuilder result = new StringBuilder("none");
        Cookie[] cks = request.getCookies();
        if (cks != null) {
            for (Cookie ck : cks) {
                result.append(ck.getValue()).append(", ");
            }
        }
        return result.toString();
    }
}
