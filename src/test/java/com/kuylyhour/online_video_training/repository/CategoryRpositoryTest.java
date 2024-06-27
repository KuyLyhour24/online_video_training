package com.kuylyhour.online_video_training.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.kuylyhour.online_video_training.entity.Category;
import com.kuylyhour.online_video_training.helper.ServiceHelper;

@DataJpaTest
public class CategoryRpositoryTest {

	@Mock
	private CategoryRepository repository;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this.repository);
	}

	@Test
	public void testFindByName() {

		List<Category> categories = ServiceHelper.getCategory();
		Category category = categories.get(0);

		when(repository.findByName(any())).thenReturn(Optional.of(category));
		Optional<Category> name = repository.findByName("Programming");

		assertThat(name.isPresent());
		assertEquals("Programming", name.get().getName());
	}

	@Test
	public void testFindByContainingName() {
		List<Category> categories = ServiceHelper.getCategory();

		when(repository.findByNameContaining("P")).thenReturn(categories);

		List<Category> nameContaining = repository.findByNameContaining("P");

		assertEquals(3, nameContaining.size());
		assertEquals("Programming", nameContaining.get(0).getName());
	}
}
