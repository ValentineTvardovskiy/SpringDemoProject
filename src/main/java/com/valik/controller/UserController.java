package com.valik.controller;

import com.valik.controller.external.model.RegisterUserDto;
import com.valik.model.User;
import com.valik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView vm = new ModelAndView();
        vm.setViewName("login");
        vm.addObject("user", new User());
        return vm;
    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public ModelAndView register(ModelAndView vm) {
        vm.setViewName("register");
        vm.addObject("userDto", RegisterUserDto.empty());
        return vm;
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(@Valid RegisterUserDto userDto, BindingResult result) {

        if (result.hasErrors()) {
            return "register";
        }

        User user = User.of(userDto);
        userService.addUser(user);
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute(value = "user") User user, ModelAndView vm) {
        return userService.getUserByEmail(user.getEmail())
                .map(r -> userService.verifyPassword(r, user))
                .filter(Optional::isPresent)
                .map(r -> {
                    vm.setViewName("home");
                    return vm;
                })
                .orElseGet(() -> {
                    vm.setViewName("login");
                    return vm;
                });
    }
}
