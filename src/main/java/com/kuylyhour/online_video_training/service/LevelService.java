package com.kuylyhour.online_video_training.service;

import com.kuylyhour.online_video_training.entity.Level;

public interface LevelService {
	
	Level save(Level level);
	Level update(Long id, Level level);
	
	Level getById(Long id);
	void delete(Long id);

}
