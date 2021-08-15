package com.breno.api.engines.impl;

import com.breno.api.domain.dtos.UserDTO;
import com.breno.api.engines.UserEngine;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class UserEngineImpl implements UserEngine {


    @Override
    public List<UserDTO> getAllUsers() {
        return new ArrayList<>();
    }
}
