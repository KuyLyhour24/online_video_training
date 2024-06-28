package com.kuylyhour.online_video_training.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kuylyhour.online_video_training.entity.Level;
import com.kuylyhour.online_video_training.exception.ResourceNotFoundException;
import com.kuylyhour.online_video_training.repository.LevelRepository;
import com.kuylyhour.online_video_training.service.LevelService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LevelServiceImpl implements LevelService {

	private final LevelRepository levelRepository;

	@Override
	public Level create(Level level) {
		return levelRepository.save(level);
	}

	@Override
	public Level getById(Long id) {
		return levelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Level", id));
	}

	@Override
	public Level update(Level level, Long id) {
		Level byId = getById(id);
		byId.setName(level.getName());
		return levelRepository.save(byId);
	}

	@Override
	public void delete(Long id) {
		Level level = getById(id);
		if (level != null) {
			levelRepository.deleteById(id);
		}

	}

	@Override
	public List<Level> getByName(String name) {
		return levelRepository.findByNameContaining(name.toUpperCase());
	}

}
