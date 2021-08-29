package com.breno.api.domain.mappers;

import com.breno.api.domain.dtos.UserDTO;
import com.breno.api.domain.entities.UserEntity;
import io.micronaut.core.annotation.Nullable;


import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class UserMapper {

    public UserDTO fromEntityToDTO(@Nullable UserEntity userEntity){
        final UserDTO response = new UserDTO();
        if(userEntity == null){
            return response;
        }
        response.setId(userEntity.getId());
        response.setAge(userEntity.getAge());
        response.setName(userEntity.getName());
        return response;
    }

    public List<UserDTO> fromEntitiesToDTOs(Iterable<UserEntity> userEntities){
        final List<UserDTO> response = new ArrayList<>();
        userEntities.forEach(value -> response.add(this.fromEntityToDTO(value)));
        return response;
    }
}
