package com.kuylyhour.online_video_training.service;

import java.util.List;

import com.kuylyhour.online_video_training.entity.Level;

public interface LevelService {

	Level create(Level level);
	Level getById(Long id);
	List<Level> getByName(String name);
	Level update(Level level, Long id);
	void delete(Long id);
}
