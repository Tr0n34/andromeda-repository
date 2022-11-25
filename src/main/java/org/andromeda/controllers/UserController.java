package org.andromeda.controllers;

import org.andromeda.controllers.routes.UserRoutes;
import org.andromeda.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping(path = "/user")
    public User subscribe(@RequestBody User userToCreate) {
        User userCreated = User.newBuilder().build();
        return userCreated;
    }


}
