package com.breno.api.engines.impl;

import com.breno.api.domain.dtos.ActionExecutionResponseDTO;
import com.breno.api.domain.dtos.UserDTO;
import com.breno.api.domain.entities.UserEntity;
import com.breno.api.domain.mappers.UserMapper;
import com.breno.api.domain.repositories.UserRepository;
import com.breno.api.engines.UserEngine;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class UserEngineImpl implements UserEngine {

    private static final String USER_DELETED_MESSAGE = "User successfully deleted!";
    private static final String USER_NOT_FOUND_MESSAGE = "User not found!";
    private static final String USER_SUCCESSFULLY_UPDATED = "User successfully updated!";
    private static final String USER_NOT_UPDATED = "User not updated!";
    private static final String USER_SUCCESSFULLY_CREATED = "User successfully created!";
    private static final String USER_NOT_CREATED = "User not created!";


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

    @Override
    public ActionExecutionResponseDTO deleteUser(Long id) {
        final ActionExecutionResponseDTO response = new ActionExecutionResponseDTO();
        final Optional<UserEntity> optionalUser = this.userRepository.findById(id);
        if(optionalUser.isPresent()){
            this.userRepository.delete(optionalUser.get());
            response.setData(this.userMapper.fromEntityToDTO(optionalUser.get()));
            response.setMessage(USER_DELETED_MESSAGE);
        } else {
            response.setMessage(USER_NOT_FOUND_MESSAGE);
        }
        return response;
    }

    @Override
    public ActionExecutionResponseDTO updateUser(Long id, UserDTO userDTO) {
        final ActionExecutionResponseDTO response = new ActionExecutionResponseDTO();
        final Optional<UserEntity> optionalUser = this.userRepository.findById(id);
        if(optionalUser.isPresent()){
            try {
                final UserEntity userEntity = optionalUser.get();
                this.userMapper.updateAllProperties(userDTO, userEntity);
                response.setData(this.userMapper.fromEntityToDTO(this.userRepository.update(userEntity)));
                response.setMessage(USER_SUCCESSFULLY_UPDATED);
            } catch (Exception e) {
                response.setMessage(USER_NOT_UPDATED);
            }
        } else {
            response.setMessage(USER_NOT_FOUND_MESSAGE);
        }
        return response;
    }

    @Override
    public ActionExecutionResponseDTO addUser(UserDTO userDTO) {
        final ActionExecutionResponseDTO response = new ActionExecutionResponseDTO();
        try{
            final UserEntity userEntity = this.userMapper.fromDtoToEntity(userDTO);
            if(userEntity != null){
                response.setData(this.userMapper.fromEntityToDTO(this.userRepository.save(userEntity)));
                response.setMessage(USER_SUCCESSFULLY_CREATED);
            } else {
                response.setMessage(USER_NOT_CREATED);
            }
        } catch (Exception e){
            response.setMessage(USER_NOT_CREATED);
        }
        return response;
    }
}
