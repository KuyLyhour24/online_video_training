package com.kuylyhour.online_video_training.service.impl;

import org.springframework.stereotype.Service;

import com.kuylyhour.online_video_training.entity.Level;
import com.kuylyhour.online_video_training.entity.Video;
import com.kuylyhour.online_video_training.exception.ResourceNotFoundException;
import com.kuylyhour.online_video_training.exception.SQLException;
import com.kuylyhour.online_video_training.repository.LevelRepository;
import com.kuylyhour.online_video_training.service.LevelService;
import com.kuylyhour.online_video_training.service.VideoService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class LevelImpl implements LevelService {

	private final LevelRepository levelRepository;
	private final VideoService videoService;
	@Override
	public Level save(Level level) {
		return levelRepository.save(level);
	}
	@Override
	public Level getById(Long id) {
		return levelRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Level", id));
	}
	@Override
	public Level update(Long id, Level level) {
		Level levelId = getById(id);
		levelId.setName(level.getName());
		return levelRepository.save(levelId);
	}
	@Override
	public void delete(Long id) {
		Video video = videoService.getById(id);
		if(video!=null) {
			throw new SQLException("Video", id);
		}
		Level level = getById(id);
		if(level!=null) {
			levelRepository.deleteById(id);
		}
		
	}

}
