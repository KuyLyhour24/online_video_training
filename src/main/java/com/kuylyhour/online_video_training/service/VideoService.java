package com.kuylyhour.online_video_training.service;

import java.math.BigDecimal;
import java.util.List;

import com.kuylyhour.online_video_training.dto.VideoUrlDTO;
import com.kuylyhour.online_video_training.entity.Video;
import com.kuylyhour.online_video_training.entity.VideoUrl;

public interface VideoService {

	Video save(Video video);
	
	Video getById(Long Id);

	List<Video> getVideoByCourseId(Long id);
	
	Video update(Video video, Long Id);
	
	void delete(Long id);
	
	List<VideoUrl> getUrlList(Long id);
	void setPrice(Long id, BigDecimal price);

}
