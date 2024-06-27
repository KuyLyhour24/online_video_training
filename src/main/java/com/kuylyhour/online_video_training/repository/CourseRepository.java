package com.kuylyhour.online_video_training.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kuylyhour.online_video_training.entity.Course;


public interface CourseRepository extends JpaRepository<Course, Long>{

	List<Course> findCourseByCategoryId(Long id);
}
