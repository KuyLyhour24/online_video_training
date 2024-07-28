package com.kuylyhour.online_video_training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.kuylyhour.online_video_training.entity.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long >, JpaSpecificationExecutor<Video>{
	List<Video> findVideoByCourseId(Long Id);

}
