package com.breno.api.engines;

import com.breno.api.domain.dtos.ActionExecutionResponseDTO;
import com.breno.api.domain.dtos.UserDTO;

import java.util.List;
public interface UserEngine {

    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id);

    ActionExecutionResponseDTO deleteUser(Long id);

    ActionExecutionResponseDTO updateUser(Long id, UserDTO userDTO);
}
