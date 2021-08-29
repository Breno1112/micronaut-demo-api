package com.breno.api.controllers;

import com.breno.api.domain.dtos.UserDTO;
import com.breno.api.engines.UserEngine;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

import javax.inject.Inject;
import java.util.List;


@Controller
public class UserControllerImpl{
    private static final String LIST_USERS_PATH = "/users";
    private static final String GET_USER_BY_ID_PATH = "/users/{id}";

    @Inject
    private UserEngine userEngine;

    @Get(value = LIST_USERS_PATH, produces = MediaType.APPLICATION_JSON)
    public HttpResponse<List<UserDTO>> getAllUsers() {
        return HttpResponse.ok().body(userEngine.getAllUsers());
    }

    @Get(value = GET_USER_BY_ID_PATH, produces = MediaType.APPLICATION_JSON)
    public HttpResponse<UserDTO> getUserById(@PathVariable(value = "id") String id){
        try{
            final Long longId = Long.parseLong(id);
            return HttpResponse.ok(this.userEngine.getUserById(longId));
        } catch (NumberFormatException e){
            return HttpResponse.badRequest();
        }
    }
}
