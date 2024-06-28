package com.kuylyhour.online_video_training.service_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kuylyhour.online_video_training.entity.Category;
import com.kuylyhour.online_video_training.entity.Course;
import com.kuylyhour.online_video_training.entity.Level;
import com.kuylyhour.online_video_training.helper.ServiceHelper;
import com.kuylyhour.online_video_training.repository.LevelRepository;
import com.kuylyhour.online_video_training.service.LevelService;
import com.kuylyhour.online_video_training.service.impl.LevelServiceImpl;

@ExtendWith(MockitoExtension.class)
public class LevelServiceTest {
	
	@Mock
	private LevelRepository levelRepository;
	
	private LevelService levelService;
	
	@BeforeEach
	public void setUp() {
		levelService = new LevelServiceImpl(levelRepository);
	}
	
	@Test
	public void testCreate() {
		List<Level> levels = ServiceHelper.getLevel();
		Level level = levels.get(0);
		
		when(levelRepository.save(level)).thenReturn(level);
		Level addLevel = levelService.create(level);
		
		assertEquals("Basic", addLevel.getName());
	}

	@Test
	public void testGetById() {
		List<Level> levels = ServiceHelper.getLevel();
		Level level = levels.get(0);
		when(levelRepository.findById(anyLong())).thenReturn(Optional.of(level));
		
		Level id = levelService.getById(1L);
		
		assertEquals("Basic", id.getName());
	}
	@Test
	public void testUpdate() {
		List<Level> levels = ServiceHelper.getLevel();
		Level level = levels.get(0);
		
		when(levelRepository.findById(anyLong())).thenReturn(Optional.of(level));
		level.setName("Advanced");
		when(levelRepository.save(any())).thenReturn(level);
	    Level update = levelService.update(level, 1L);
		
		assertEquals("Advanced", update.getName());
	}
	@Test
	public void testDelete() {
		List<Level> levels = ServiceHelper.getLevel();
		Long id = levels.get(0).getId();		
		when(levelRepository.findById(anyLong())).thenReturn(Optional.of(levels.get(0)));
		levelService.delete(id);

		Mockito.verify(levelRepository).deleteById(id);
	}
	@Test
	public void testGetLevel() {

		List<Level> levels = ServiceHelper.getLevel();

		when(levelRepository.findByNameContaining(any())).thenReturn(levels);

		List<Level> level = levelService.getByName("B");

		assertEquals("Basic", level.get(0).getName());

	}
}
