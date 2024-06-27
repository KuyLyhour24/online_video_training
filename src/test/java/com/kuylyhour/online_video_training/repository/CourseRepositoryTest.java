package com.kuylyhour.online_video_training.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.kuylyhour.online_video_training.entity.Course;
import com.kuylyhour.online_video_training.helper.ServiceHelper;

@DataJpaTest
public class CourseRepositoryTest {
	
	@Mock
	private CourseRepository repository;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(repository);
	}

	@Test
	public void testFindCourseByCategoryId() {
		List<Course> course = ServiceHelper.getCourse();
		
		when(repository.findCourseByCategoryId(anyLong())).thenReturn(course);
		
		List<Course> courseByCategoryId = repository.findCourseByCategoryId(1L);
		
		assertEquals("Python", courseByCategoryId.get(1).getName());
	}
}
