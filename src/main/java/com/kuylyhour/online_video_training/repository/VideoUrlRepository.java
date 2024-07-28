package com.kuylyhour.online_video_training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.kuylyhour.online_video_training.entity.VideoUrl;

@Repository
public interface VideoUrlRepository extends JpaRepository<VideoUrl, Long>, JpaSpecificationExecutor<VideoUrl>{

	List<VideoUrl> findVideoUrlByVideoId(Long id);
}
