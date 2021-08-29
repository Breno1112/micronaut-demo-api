package com.breno.api.controllers;

import com.breno.api.domain.dtos.UserDTO;
import com.breno.api.engines.UserEngine;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


@MicronautTest
public class UserControllerTest {

    @Inject
    UserEngine userEngine;

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void testItReturnsEmptyUserList(){
        final UserDTO[] response = client.toBlocking().retrieve("/users", UserDTO[].class);
        Assertions.assertEquals(0, response.length);
    }


}
