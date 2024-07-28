package com.kuylyhour.online_video_training.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.kuylyhour.online_video_training.dto.VideoDTO;
import com.kuylyhour.online_video_training.dto.VideoUrlDTO;
import com.kuylyhour.online_video_training.entity.Video;
import com.kuylyhour.online_video_training.entity.VideoUrl;
import com.kuylyhour.online_video_training.service.CourseService;
import com.kuylyhour.online_video_training.service.LevelService;
import com.kuylyhour.online_video_training.service.VideoUrlService;

@Mapper(componentModel = "spring" , uses = {CourseService.class, LevelService.class, VideoUrlService.class})
public interface VideoMapper {
	VideoMapper INSTANCE = Mappers.getMapper(VideoMapper.class);
	@Mapping(target = "course" , source = "courseId")
	@Mapping(target = "level", source = "levelId")
	Video toVideo(VideoDTO videoDTO);
	@Mapping(target = "courseId" , source = "course.id")
	@Mapping(target = "levelId", source = "level.id")
	VideoDTO toVideoDTO(Video video);
	
	
	@Mapping(target = "id" , ignore = true)
	VideoUrl toVideoUrl(VideoUrlDTO videoUrlDTO,Video video);

}
