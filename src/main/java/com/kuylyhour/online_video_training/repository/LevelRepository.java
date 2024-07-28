package com.kuylyhour.online_video_training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kuylyhour.online_video_training.entity.Level;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long>{

}
