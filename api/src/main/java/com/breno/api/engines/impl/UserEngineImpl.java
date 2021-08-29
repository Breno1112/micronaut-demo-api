package com.breno.api.engines.impl;

import com.breno.api.domain.dtos.UserDTO;
import com.breno.api.domain.mappers.UserMapper;
import com.breno.api.domain.repositories.UserRepository;
import com.breno.api.engines.UserEngine;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class UserEngineImpl implements UserEngine {


    @Inject
    private UserRepository userRepository;

    @Inject
    private UserMapper userMapper;


    @Override
    public List<UserDTO> getAllUsers() {
        return userMapper.fromEntitiesToDTOs(this.userRepository.findAll());
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userMapper.fromEntityToDTO(this.userRepository.findById(id).orElse(null));
    }
}
