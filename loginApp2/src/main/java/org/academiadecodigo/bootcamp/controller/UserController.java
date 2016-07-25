package org.academiadecodigo.bootcamp.controller;

import org.academiadecodigo.bootcamp.user.User;
import org.academiadecodigo.bootcamp.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by codecadet on 20/07/16.
 */
@RestController
@SessionAttributes("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/mainPage")
    public ModelAndView showMainPage(ModelAndView modelAndView) {

        modelAndView = new ModelAndView("mainPage");
        modelAndView.addObject("userList", userService.getUserList());
        modelAndView.addObject("newUser", new User());
        return modelAndView;

    }

    @RequestMapping(method = RequestMethod.POST, value = "/mainPage/logout")
    public String logout() {
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/mainPage/addUser/newUser")
    public String addUser(@ModelAttribute("newUser") User user) {

        userService.addUser(user.getUsername(), user.getPassword(), user.getEmail());
        return "redirect:/mainPage";

    }

    @RequestMapping(method = RequestMethod.POST, value = "/mainPage/deleteUser/{username}")
    public String removeUser(@PathVariable("username") String username) {

        User user = userService.getUser(username);
        userService.removeUser(user);
        return "redirect:/mainPage";

    }

}
