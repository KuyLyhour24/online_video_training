package com.kuylyhour.online_video_training.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.kuylyhour.online_video_training.entity.Course;
import com.kuylyhour.online_video_training.helper.ServiceHelper;
import com.kuylyhour.online_video_training.mapper.CourseMapper;
import com.kuylyhour.online_video_training.service.CourseService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CourseControllerTest {
	
	@Mock
	private CourseService courseService;
	@Mock
	private CourseMapper courseMapper;
	
	@Spy
	@InjectMocks
	private CourseController controller;
	
	@BeforeEach
	public void setUp() {
		controller = new CourseController(courseService, courseMapper);
	}
	
	@Test
	public void testCreate() {
		List<Course> courses = ServiceHelper.getCourse();
		Course course = courses.get(0);
		
		when(courseService.save(any())).thenReturn(course);
		ResponseEntity<?> responseEntity = controller.create(courseMapper.toCourseDTO(course));
		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	@Test
	public void teatGetCourse() {
		List<Course> courses = ServiceHelper.getCourse();
		Course course = courses.get(0);
		when(courseService.getById(anyLong())).thenReturn(course);
		ResponseEntity<?> responseEntity = controller.getCourse(1L);
		
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
	}
	
	@Test
	public void testUpdate() {
		List<Course> courses = ServiceHelper.getCourse();
		Course course = courses.get(0);
		
		when(courseService.update(any(), anyLong())).thenReturn(course);
		ResponseEntity<?> responseEntity = controller.update(1L, courseMapper.toCourseDTO(course));
		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	@Test
	public void testDelete() {
		List<Course> courses = ServiceHelper.getCourse();
		Long id = courses.get(0).getId();
		
		doNothing().when(courseService).delete(id);
		
		ResponseEntity<?> responseEntity = controller.delete(id);
		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

}
