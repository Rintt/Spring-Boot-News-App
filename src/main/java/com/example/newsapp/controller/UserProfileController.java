package com.example.newsapp.controller;

import com.example.newsapp.repository.NewsUserRepository;
import com.example.newsapp.repository.UnknownNewsUserException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class UserProfileController {

    private NewsUserRepository newsUserRepository;
    public UserProfileController(NewsUserRepository newsUserRepository) {
        this.newsUserRepository = newsUserRepository;
    }

    @GetMapping("/user/profile/{username}")
    public String showProfile(Model model,
                              @PathVariable("username") String username) {
        var user = newsUserRepository.findByUsername(username);
        if (user == null) {
            throw new UnknownNewsUserException("User not found");
        }
        model.addAttribute("newsUser", user);
        return "profile";
    }

}
