package com.kuylyhour.online_video_training.service_test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kuylyhour.online_video_training.entity.Course;
import com.kuylyhour.online_video_training.helper.ServiceHelper;
import com.kuylyhour.online_video_training.repository.CourseRepository;
import com.kuylyhour.online_video_training.service.CourseService;
import com.kuylyhour.online_video_training.service.impl.CourseServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CourseServiceTest {
	
	@Mock
	private CourseRepository courseRepository;
	
	private CourseService courseService;
	
	@BeforeEach
	public void setUp() {
		courseService = new CourseServiceImpl(courseRepository);
	}
	
	@Test 
	public void testSave() {
		List<Course> courses = ServiceHelper.getCourse();
		Course course = courses.get(0);
		
		when(courseRepository.save(course)).thenReturn(course);
		
		Course save = courseService.save(course);
		
		assertEquals(1L, save.getId());
		assertEquals("Java", save.getName());
	}
	
	@Test
	public void testGetById() {
		List<Course> courses = ServiceHelper.getCourse();
		Course course = courses.get(0);
		
		when(courseRepository.findById(anyLong())).thenReturn(Optional.of(course));
		
		Course id = courseService.getById(1L);
		
		assertEquals("Java", id.getName());
	}
	@Test
	public void testUpdate() {
		List<Course> courses = ServiceHelper.getCourse();
		Course course = courses.get(0);
		
		when(courseRepository.findById(anyLong())).thenReturn(Optional.of(course));
		course.setName("Javascript");
		when(courseRepository.save(any())).thenReturn(course);
		Course update = courseService.update(course, 1L);
		
		assertEquals("Javascript", update.getName());
		
	}

	@Test
	public void testDelete() {
		List<Course> courses = ServiceHelper.getCourse();
		Long id = courses.get(0).getId();
		
		when(courseRepository.findById(anyLong())).thenReturn(Optional.of(courses.get(0)));
		courseService.delete(id);

		Mockito.verify(courseRepository).deleteById(id);
	}
}
