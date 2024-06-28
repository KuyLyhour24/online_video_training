package com.kuylyhour.online_video_training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kuylyhour.online_video_training.entity.Level;

public interface LevelRepository  extends JpaRepository<Level, Long>{

	List<Level> findByNameContaining(String name);
}
