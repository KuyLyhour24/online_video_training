package com.kuylyhour.online_video_training.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kuylyhour.online_video_training.dto.LevelDTO;
import com.kuylyhour.online_video_training.entity.Level;
import com.kuylyhour.online_video_training.service.LevelService;

@Mapper(componentModel = "spring" , uses = {LevelService.class})
public interface LevelMapper {
	LevelMapper INSTANCE = Mappers.getMapper(LevelMapper.class);
	Level toLevel(LevelDTO dto);
	Level toLevelDTO(Level level);

}
