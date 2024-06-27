package com.kuylyhour.online_video_training.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kuylyhour.online_video_training.entity.Course;
import com.kuylyhour.online_video_training.exception.DuplicateValueException;
import com.kuylyhour.online_video_training.exception.ResourceNotFoundException;
import com.kuylyhour.online_video_training.repository.CourseRepository;
import com.kuylyhour.online_video_training.service.CategoryService;
import com.kuylyhour.online_video_training.service.CourseService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

	private final CourseRepository courseRepository;
	
	@Override
	public Course save(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public Course getById(Long id) {
		return courseRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Course", id));
	}

	@Override
	public Course update(Course course, Long id) {
		Course courseId = getById(id);
		courseId.setName(course.getName());
		courseId.setCategory(course.getCategory());
		return courseRepository.save(courseId);
	}

	@Override
	public void delete(Long id) {
		Course course = getById(id);
		if(course !=null) {
			courseRepository.deleteById(id);
		}
		
	}
	

}
