package com.kuylyhour.online_video_training.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kuylyhour.online_video_training.dto.LevelDTO;
import com.kuylyhour.online_video_training.entity.Level;

@Mapper(componentModel = "spring")
public interface LevelMapper {
	
	LevelMapper INSTANCE = Mappers.getMapper(LevelMapper.class);
	
	Level toLevel(LevelDTO levelDTO);
	LevelDTO toLevelDTO(Level level);
}
