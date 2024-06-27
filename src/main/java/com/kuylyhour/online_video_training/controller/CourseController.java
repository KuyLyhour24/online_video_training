package com.kuylyhour.online_video_training.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kuylyhour.online_video_training.dto.CourseDTO;
import com.kuylyhour.online_video_training.entity.Course;
import com.kuylyhour.online_video_training.mapper.CourseMapper;
import com.kuylyhour.online_video_training.service.CourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {
	
	private final CourseService courseService;
	
	private final CourseMapper courseMapper;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody CourseDTO courseDTO){
		Course course = courseMapper.toCourse(courseDTO);
		course = courseService.save(course);
		return ResponseEntity.ok(courseMapper.toCourseDTO(course));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getCourse(@PathVariable("id") Long id ){
		Course course = courseService.getById(id);
		return ResponseEntity.ok(course);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		courseService.delete(id);
		return ResponseEntity.ok().build();
	}
	@PutMapping("update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id,@RequestBody CourseDTO courseDTO){
		Course course = courseMapper.toCourse(courseDTO);
		Course update = courseService.update(course, id);
		return ResponseEntity.ok(courseMapper.toCourseDTO(update));
	}
}
