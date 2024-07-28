package com.kuylyhour.online_video_training.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.kuylyhour.online_video_training.dto.VideoListDTO;
import com.kuylyhour.online_video_training.dto.VideoUrlDTO;
import com.kuylyhour.online_video_training.entity.VideoUrl;
import com.kuylyhour.online_video_training.service.VideoService;

@Mapper(componentModel = "spring" , uses = {VideoService.class})
public interface VideoUrlMapper {
	@Mapping(target="video", source = "videoId")
	VideoUrl toVideoUrl(VideoUrlDTO dto);
	@Mapping(target = "videoId" , source = "video.id")
	VideoUrlDTO toVideoUrlDTO(VideoUrl url);
	
	VideoListDTO toList(VideoUrl url);

}
