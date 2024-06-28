package com.kuylyhour.online_video_training.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.kuylyhour.online_video_training.entity.Category;
import com.kuylyhour.online_video_training.entity.Level;
import com.kuylyhour.online_video_training.helper.ServiceHelper;

@DataJpaTest
public class LevelRepositoryTest {
	@Mock
	private LevelRepository repository;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(repository);
	}

	@Test
	public void testFindByContainingName() {
		List<Level> level = ServiceHelper.getLevel();

		when(repository.findByNameContaining("B")).thenReturn(level);

		List<Level> nameContaining = repository.findByNameContaining("B");

		assertEquals(2, nameContaining.size());
		assertEquals("Basic", nameContaining.get(0).getName());
	}
}
