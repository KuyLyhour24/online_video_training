package com.kuylyhour.online_video_training.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.kuylyhour.online_video_training.dto.VideoUrlDTO;
import com.kuylyhour.online_video_training.entity.Video;
import com.kuylyhour.online_video_training.entity.VideoUrl;
import com.kuylyhour.online_video_training.exception.ResourceNotFoundException;
import com.kuylyhour.online_video_training.mapper.VideoMapper;
import com.kuylyhour.online_video_training.mapper.VideoUrlMapper;
import com.kuylyhour.online_video_training.repository.VideoRepository;
import com.kuylyhour.online_video_training.repository.VideoUrlRepository;
import com.kuylyhour.online_video_training.service.VideoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VideoSerrviceIpml implements VideoService {
	private final VideoRepository videoRepository;
	private final VideoUrlRepository videoUrlRepository;
	@Override
	public Video save(Video video) {
		String name = "%s %s".formatted(video.getCourse().getName(), video.getLevel().getName());
		video.setTitle(name);
		return videoRepository.save(video);
	}

	@Override
	public List<Video> getVideoByCourseId(Long id) {
		return videoRepository.findVideoByCourseId(id);
	}

	@Override
	public Video getById(Long Id) {
		return videoRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Video", Id));
	}

	@Override
	public Video update(Video video, Long Id) {
		Video videoId = getById(Id);
		videoId.setTitle(video.getTitle());
		videoId.setDescription(video.getDescription());
		videoId.setImageUrl(video.getImageUrl());
		videoId.setCourse(video.getCourse());
		return videoRepository.save(videoId);
	}

	@Override
	public void delete(Long id) {
		Video video = getById(id);
		if (video != null) {
			videoRepository.deleteById(id);
		}
	}

	@Override
	public List<VideoUrl> getUrlList(Long id) {
		Video video = getById(id);
		List<VideoUrl> list = videoUrlRepository.findVideoUrlByVideoId(video.getId());
		return list;
	}

	@Override
	public void setPrice(Long id, BigDecimal price) {
		Video video = getById(id);
		video.setPrice(price);
		videoRepository.save(video);
		
	}

}
