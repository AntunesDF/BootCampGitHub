package org.academiadecodigo.bootcamp.controller;

import org.academiadecodigo.bootcamp.user.User;
import org.academiadecodigo.bootcamp.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by codecadet on 22/07/16.
 */
@RestController
@SessionAttributes("user")
public class EditController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/editUser/{username}")
    public ModelAndView showEditUser(ModelAndView modelAndView, @PathVariable("username") String username, RedirectAttributes redirectAttributes) {

        modelAndView = new ModelAndView("editUser");
        modelAndView.addObject("editUser", userService.getUser(username));
        modelAndView.addObject("newUser", userService.getUser(username));
        //redirectAttributes.addFlashAttribute("newUser", new User());
        return modelAndView;

    }

    @RequestMapping(method = RequestMethod.POST, value = "/editUser/editUser/edit")
    public String editUser(@ModelAttribute("editUser") User user, @ModelAttribute("newUser") User userInfo) {

        userService.editUser(user, userInfo);

        //userService.addUser(user.getUsername(), user.getPassword(), user.getEmail());
        return "redirect:/mainPage";

    }

    @RequestMapping(method = RequestMethod.POST, value = "/editUser/editUser/back")
    public String back() {
        return "redirect:/mainPage";
    }

}
