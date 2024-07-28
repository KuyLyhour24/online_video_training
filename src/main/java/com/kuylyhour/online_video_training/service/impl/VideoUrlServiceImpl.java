package com.kuylyhour.online_video_training.service.impl;

import org.springframework.stereotype.Service;

import com.kuylyhour.online_video_training.dto.VideoUrlDTO;
import com.kuylyhour.online_video_training.entity.VideoUrl;
import com.kuylyhour.online_video_training.exception.ResourceNotFoundException;
import com.kuylyhour.online_video_training.repository.VideoUrlRepository;
import com.kuylyhour.online_video_training.service.VideoService;
import com.kuylyhour.online_video_training.service.VideoUrlService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class VideoUrlServiceImpl implements VideoUrlService{
private final VideoUrlRepository repository;
private final VideoService videoService;
	@Override
	public VideoUrl save(VideoUrl videoUrl) {
		videoService.getById(videoUrl.getVideo().getId());
		return repository.save(videoUrl);
	}
	@Override
	public VideoUrl getById(Long id) {
		return repository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Video url", id));
	}
	@Override
	public VideoUrl update(Long id, VideoUrl videourl) {
		VideoUrl urlId = getById(id);
		urlId.setName(videourl.getName());
		urlId.setUrl(videourl.getUrl());
		urlId.setVideo(videourl.getVideo());
		return repository.save(urlId);
	}
	@Override
	public void delete(Long id) {
		VideoUrl url = getById(id);
		if(url!=null) {
			repository.deleteById(id);
		}
	}
	

}
