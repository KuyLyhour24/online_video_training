package com.kuylyhour.online_video_training.service;

import java.util.List;

import com.kuylyhour.online_video_training.entity.Course;

public interface CourseService {
	
	Course save(Course course);
	Course getById(Long id);
	
	Course update(Course course, Long id);
	
	//Page<Category> getCategoryPage(Map<String,String> params);
	
	void delete(Long id);

}
