package com.kuylyhour.online_video_training.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kuylyhour.online_video_training.dto.UserDTO;
import com.kuylyhour.online_video_training.entity.User;

@Mapper
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	User toUser(UserDTO userDTO);
	UserDTO toUserDTO (User user);

}
