package com.kuylyhour.online_video_training.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
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

import com.kuylyhour.online_video_training.entity.Category;
import com.kuylyhour.online_video_training.entity.Course;
import com.kuylyhour.online_video_training.entity.Level;
import com.kuylyhour.online_video_training.helper.ServiceHelper;
import com.kuylyhour.online_video_training.mapper.LevelMapper;
import com.kuylyhour.online_video_training.service.LevelService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class LevelControllerTest {

	@Mock
	private LevelService service;
	@Mock
	private LevelMapper mapper;
	
	@Spy
	@InjectMocks
	private LevelController controller;
	
	@BeforeEach
	public void setUp() {
		controller = new LevelController(service, mapper);
	}
	
	@Test
	public void testCreate() {
		 List<Level> levels = ServiceHelper.getLevel();
		 Level level = levels.get(0);
		
		when(service.create(any())).thenReturn(level);
		ResponseEntity<?> responseEntity = controller.create(mapper.toLevelDTO(level));
		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	@Test
	public void teatGetById() {
		List<Level> levels = ServiceHelper.getLevel();
		 Level level = levels.get(0);
		when(service.getById(anyLong())).thenReturn(level);
		ResponseEntity<?> responseEntity = controller.getById(1L);
		
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
	}
	@Test
	public void testUpdate() {
		List<Level> levels = ServiceHelper.getLevel();
		 Level level = levels.get(0);		
		when(service.update(any(), anyLong())).thenReturn(level);
		ResponseEntity<?> responseEntity = controller.update(1L, mapper.toLevelDTO(level));
		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	@Test
	public void testDelete() {
		List<Level> levels = ServiceHelper.getLevel();
		 Long id = levels.get(0).getId();
		
		doNothing().when(service).delete(id);
		
		ResponseEntity<?> responseEntity = controller.delete(id);
		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	@Test
	public void testGetLevel() {
		List<Level> levels = ServiceHelper.getLevel();
		 Level level = levels.get(0);	
		when(service.getByName("Basic")).thenReturn(levels);
		ResponseEntity<?> responseEntity = controller.getByName(level.getName());
		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
}
