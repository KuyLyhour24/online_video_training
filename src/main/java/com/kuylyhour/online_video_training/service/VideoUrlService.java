package com.kuylyhour.online_video_training.service;

import com.kuylyhour.online_video_training.entity.VideoUrl;

public interface VideoUrlService {

	VideoUrl save(VideoUrl videoUrl);
	VideoUrl getById(Long id);
	VideoUrl update(Long id, VideoUrl videourl);
	void delete(Long id);
}
