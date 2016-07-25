package org.academiadecodigo.bootcamp.controller;

import org.academiadecodigo.bootcamp.user.User;
import org.academiadecodigo.bootcamp.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by codecadet on 15/07/16.
 */
@RestController
@SessionAttributes("user")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ModelAndView showLogin() {

        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("user", new User());
        return modelAndView;

    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public String doLogin(Model model, @Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "login";
        }

        // If user/pass fields are empty, display the same view again
        if (user.getUsername() == null || user.getUsername().isEmpty() || user.getPassword() == null || user.getPassword().isEmpty()) {
            return "login";
        }

        // If auth succeeds, render a new view
        if (userService.authenticate(user.getUsername(), user.getPassword())) {
            model.addAttribute("user", user);
            return "redirect:/mainPage";

            // If auth fails, render the same view with error message
        } else {
            model.addAttribute("error", "Authentication Failure");
            return "login";
        }

    }

}