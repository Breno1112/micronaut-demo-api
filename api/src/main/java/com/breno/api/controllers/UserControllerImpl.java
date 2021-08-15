package com.breno.api.controllers;

import com.breno.api.domain.dtos.UserDTO;
import com.breno.api.engines.UserEngine;
import io.micronaut.context.BeanContext;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;


@Controller
public class UserControllerImpl{
    private static final String LIST_USERS_PATH = "/users";
    private final BeanContext context = BeanContext.run();
    private final UserEngine userEngine = context.getBean(UserEngine.class);

    @Get(value = LIST_USERS_PATH, produces = MediaType.APPLICATION_JSON)
    public List<UserDTO> getAllUsers() {
        return userEngine.getAllUsers();
    }
}
