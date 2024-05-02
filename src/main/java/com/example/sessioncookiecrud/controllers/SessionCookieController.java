package com.example.sessioncookiecrud.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SessionCookieController {

    @GetMapping("/")
    public String index() {
        return "home/index";
    }

    @GetMapping("/set_session_cookie")
    public String setSessionCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("mySessionCookie", "Hello_Session_Cookie_hello");
        response.addCookie(cookie);
        return "redirect:/get_session_cookie";
    }

    @GetMapping("/get_session_cookie")
    public String getSessionCookie(@CookieValue(name = "mySessionCookie", defaultValue = "N/A") String cookieValue, Model model) {
        model.addAttribute("cookieValue", cookieValue);
        return "home/show_session_cookie";
    }

    @GetMapping("/delete_session_cookie")
    public String deleteCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("mySessionCookie", null);
        cookie.setMaxAge(0); // Tells browser to delete cookie
        response.addCookie(cookie);
        return "redirect:/get_session_cookie";
    }

    @GetMapping("/update_session_cookie")
    public String updateSessionCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("mySessionCookie", "Updated_information");
        response.addCookie(cookie);
        return "redirect:/get_session_cookie";
    }
}
