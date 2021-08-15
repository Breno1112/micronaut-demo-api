package com.breno.api.engines;

import com.breno.api.domain.dtos.UserDTO;

import java.util.List;
public interface UserEngine {

    List<UserDTO> getAllUsers();
}
