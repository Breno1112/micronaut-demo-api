package com.breno.api.controllers;

import com.breno.api.domain.dtos.UserDTO;
import com.breno.api.engines.UserEngine;
import io.micronaut.core.io.ResourceLoader;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.h2.tools.RunScript;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@MicronautTest
public class UserControllerTest {

    @Inject
    UserEngine userEngine;

    @Inject
    @Client("/")
    HttpClient client;

    @Inject
    DataSource dataSource;

    @Inject
    ResourceLoader resourceLoader;

    @Test
    void testItReturnsEmptyUserList(){
        final UserDTO[] response = client.toBlocking().retrieve("/users", UserDTO[].class);
        Assertions.assertEquals(0, response.length);
    }

    @Test
    void testItReturnsSingleUser() throws SQLException {
        final Optional<InputStream> optionalSqlScript = this.resourceLoader.getResourceAsStream("addSingleUser.sql");
        final InputStream sqlScript = optionalSqlScript.get();
        RunScript.execute(dataSource.getConnection(), new InputStreamReader(sqlScript, StandardCharsets.UTF_8));
        final UserDTO[] response = client.toBlocking().retrieve("/users", UserDTO[].class);
        Assertions.assertEquals(0, response.length);
    }




}
