package com.valik.controller.rest;

import com.valik.controller.external.model.UserDto;
import com.valik.model.User;
import com.valik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestUserController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public ResponseEntity<UserDto> getByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email)
                .map(UserDto::of)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }
}
